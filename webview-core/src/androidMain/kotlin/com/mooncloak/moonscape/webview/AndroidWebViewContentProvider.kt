package com.mooncloak.moonscape.webview

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

@Composable
public fun UseAndroidWebView(
    factory: WebViewComponentFactory<AndroidWebViewState, AndroidWebViewNavigator> = AndroidWebViewComponentFactory(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalWebViewComponentFactory provides factory, content)
}

public class AndroidWebViewComponentFactory public constructor(
    private val webViewClientFactory: () -> AndroidWebViewClient = { AndroidWebViewClient() },
    private val webChromeClientFactory: () -> AndroidWebChromeClient = { AndroidWebChromeClient() }
) : WebViewComponentFactory<AndroidWebViewState, AndroidWebViewNavigator> {

    override fun createWebViewContentProvider(): WebViewContentProvider<AndroidWebViewState, AndroidWebViewNavigator> =
        AndroidWebViewContentProvider(
            webViewClientFactory = webViewClientFactory,
            webChromeClientFactory = webChromeClientFactory
        )

    override fun createWebViewState(content: WebContent?): AndroidWebViewState =
        AndroidWebViewState(webContent = content ?: WebContent.NavigatorOnly)

    override fun createWebViewStateSaver(): Saver<AndroidWebViewState, Any> = AndroidWebStateSaver

    override fun createWebViewNavigator(): AndroidWebViewNavigator =
        AndroidWebViewNavigator(initialEvent = WebViewNavigator.NavigationEvent.StopLoading)
}

public class AndroidWebViewContentProvider public constructor(
    private val webViewClientFactory: () -> AndroidWebViewClient = { AndroidWebViewClient() },
    private val webChromeClientFactory: () -> AndroidWebChromeClient = { AndroidWebChromeClient() }
) : WebViewContentProvider<AndroidWebViewState, AndroidWebViewNavigator> {

    @Composable
    override fun Content(
        state: AndroidWebViewState,
        navigator: AndroidWebViewNavigator,
        modifier: Modifier,
        captureBackPresses: Boolean
    ) {
        BoxWithConstraints(modifier) {
            // WebView changes it's layout strategy based on
            // it's layoutParams. We convert from Compose Modifier to
            // layout params here.
            val width = if (constraints.hasFixedWidth) {
                FrameLayout.LayoutParams.MATCH_PARENT
            } else {
                FrameLayout.LayoutParams.WRAP_CONTENT
            }

            val height = if (constraints.hasFixedHeight) {
                FrameLayout.LayoutParams.MATCH_PARENT
            } else {
                FrameLayout.LayoutParams.WRAP_CONTENT
            }

            val layoutParams = FrameLayout.LayoutParams(
                width,
                height
            )

            val client = remember { webViewClientFactory.invoke() }
            val chromeClient = remember { webChromeClientFactory.invoke() }

            WebView(
                state = state,
                layoutParams = layoutParams,
                modifier = Modifier,
                captureBackPresses = captureBackPresses,
                navigator = navigator,
                client = client,
                chromeClient = chromeClient
            )
        }
    }

    @Composable
    private fun WebView(
        state: AndroidWebViewState,
        navigator: AndroidWebViewNavigator,
        layoutParams: FrameLayout.LayoutParams,
        modifier: Modifier = Modifier,
        captureBackPresses: Boolean = true,
        onCreated: (WebView) -> Unit = {},
        onDispose: (WebView) -> Unit = {},
        client: AndroidWebViewClient = remember { AndroidWebViewClient() },
        chromeClient: AndroidWebChromeClient = remember { AndroidWebChromeClient() },
        factory: ((Context) -> WebView)? = null,
    ) {
        val webView = state.webView

        BackHandler(captureBackPresses && navigator.canGoBack) {
            webView?.goBack()
        }

        if (webView != null) {
            LaunchedEffect(webView, navigator) {
                with(navigator) {
                    handleNavigationEvents(webView)
                }
            }

            LaunchedEffect(webView, state) {
                snapshotFlow { state.content }.collect { content ->
                    when (content) {
                        is WebContent.Url -> {
                            webView.loadUrl(content.url, content.additionalHttpHeaders)
                        }

                        is WebContent.Data -> {
                            webView.loadDataWithBaseURL(
                                content.baseUrl,
                                content.data,
                                content.mimeType,
                                content.encoding,
                                content.historyUrl
                            )
                        }

                        is WebContent.Post -> {
                            webView.postUrl(
                                content.url,
                                content.postData
                            )
                        }

                        is WebContent.NavigatorOnly -> {
                            // NO-OP
                        }

                        is WebContent.File -> {
                            // TODO: Load file content as data and then invoke the load data function.
                            TODO()
                        }
                    }
                }
            }
        }

        // Set the state of the client and chrome client
        // This is done internally to ensure they always are the same instance as the
        // parent Web composable
        client.state = state
        client.navigator = navigator
        chromeClient.state = state

        AndroidView(
            factory = { context ->
                (factory?.invoke(context) ?: WebView(context)).apply {
                    onCreated(this)

                    this.layoutParams = layoutParams

                    state.viewState?.let {
                        this.restoreState(it)
                    }

                    webChromeClient = chromeClient
                    webViewClient = client

                    // Avoid covering other components
                    this.setLayerType(state.settings.layerType.value, null)

                    settings.apply {
                        state.settings.let {
                            javaScriptEnabled = it.isJavaScriptEnabled
                            userAgentString = it.customUserAgentString
                            allowFileAccessFromFileURLs = it.allowFileAccessFromFileURLs
                            allowUniversalAccessFromFileURLs = it.allowUniversalAccessFromFileURLs
                            setSupportZoom(it.supportZoom)
                        }

                        state.settings.let {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                safeBrowsingEnabled = it.safeBrowsingEnabled
                            }
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                isAlgorithmicDarkeningAllowed = it.isAlgorithmicDarkeningAllowed
                            }
                            setBackgroundColor(state.settings.backgroundColor.toArgb())
                            allowFileAccess = it.allowFileAccess
                            textZoom = it.textZoom
                            useWideViewPort = it.useWideViewPort
                            standardFontFamily = it.standardFontFamily
                            defaultFontSize = it.defaultFontSize
                            loadsImagesAutomatically = it.loadsImagesAutomatically
                            domStorageEnabled = it.domStorageEnabled
                            mediaPlaybackRequiresUserGesture = it.mediaPlaybackRequiresUserGesture
                        }
                    }
                }.also { state.webView = it }
            },
            modifier = modifier,
            onRelease = {
                onDispose(it)
            }
        )
    }
}

public open class AndroidWebViewClient : WebViewClient() {

    public open lateinit var state: AndroidWebViewState
        internal set

    public open lateinit var navigator: AndroidWebViewNavigator
        internal set

    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)

        state.loadingState = LoadingState.Loading(0.0f)
        state.errorsForCurrentRequest.clear()
        state.pageTitle = null
        state.pageIcon = null

        state.lastLoadedUrl = url
    }

    override fun onPageFinished(view: WebView, url: String?) {
        super.onPageFinished(view, url)

        state.loadingState = LoadingState.Finished
    }

    override fun doUpdateVisitedHistory(view: WebView, url: String?, isReload: Boolean) {
        super.doUpdateVisitedHistory(view, url, isReload)

        navigator.canGoBack = view.canGoBack()
        navigator.canGoForward = view.canGoForward()
    }

    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)

        if (error != null) {
            state.errorsForCurrentRequest.add(
                WebViewError(
                    code = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) error.errorCode else null,
                    description = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) error.description.toString() else null,
                    isFromMainFrame = request.isForMainFrame
                )
            )
        }
    }
}

public open class AndroidWebChromeClient : WebChromeClient() {

    public open lateinit var state: AndroidWebViewState
        internal set

    override fun onReceivedTitle(view: WebView, title: String?) {
        super.onReceivedTitle(view, title)

        state.pageTitle = title
    }

    override fun onReceivedIcon(view: WebView, icon: Bitmap?) {
        super.onReceivedIcon(view, icon)

        state.pageIcon = icon
    }

    override fun onProgressChanged(view: WebView, newProgress: Int) {
        super.onProgressChanged(view, newProgress)

        if (state.loadingState is LoadingState.Finished) return

        state.loadingState = LoadingState.Loading(progress = newProgress / 100.0f)
    }
}

@Stable
public class AndroidWebViewState public constructor(
    webContent: WebContent = WebContent.NavigatorOnly,
    settings: WebSettings = WebSettings()
) : WebViewState {

    public override var settings: WebSettings by mutableStateOf(settings)
        internal set

    public override var lastLoadedUrl: String? by mutableStateOf(null)
        internal set

    /**
     *  The content being loaded by the WebView
     */
    public override var content: WebContent by mutableStateOf(webContent)

    /**
     * Whether the WebView is currently [LoadingState.Loading] data in its main frame (along with
     * progress) or the data loading has [LoadingState.Finished]. See [LoadingState]
     */
    public override var loadingState: LoadingState by mutableStateOf(LoadingState.Initializing)
        internal set

    /**
     * The title received from the loaded content of the current page
     */
    public override var pageTitle: String? by mutableStateOf(null)
        internal set

    /**
     * the favicon received from the loaded content of the current page
     */
    public var pageIcon: Bitmap? by mutableStateOf(null)
        internal set

    /**
     * A list for errors captured in the last load. Reset when a new page is loaded.
     * Errors could be from any resource (iframe, image, etc.), not just for the main page.
     * For more fine grained control use the OnError callback of the WebView.
     */
    public override val errorsForCurrentRequest: SnapshotStateList<WebViewError> = mutableStateListOf()

    /**
     * The saved view state from when the view was destroyed last. To restore state,
     * use the navigator and only call loadUrl if the bundle is null.
     * See WebViewSaveStateSample.
     */
    public var viewState: Bundle? = null
        internal set

    // We need access to this in the state saver. An internal DisposableEffect or AndroidView
    // onDestroy is called after the state saver and so can't be used.
    internal var webView by mutableStateOf<WebView?>(null)
}

public class AndroidWebViewNavigator public constructor(
    initialEvent: WebViewNavigator.NavigationEvent
) : WebViewNavigator {

    private val mutableEvent = mutableStateOf(initialEvent)

    override val event: WebViewNavigator.NavigationEvent by mutableEvent

    private val mutableRecentEvents = mutableStateListOf<WebViewNavigator.NavigationEvent>()

    override val recentEvents: List<WebViewNavigator.NavigationEvent>
        get() = mutableRecentEvents

    /**
     * True when the web view is able to navigate backwards, false otherwise.
     */
    public override var canGoBack: Boolean by mutableStateOf(false)
        internal set

    /**
     * True when the web view is able to navigate forwards, false otherwise.
     */
    public override var canGoForward: Boolean by mutableStateOf(false)
        internal set

    private val mutex = Mutex(locked = false)

    public override suspend fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>) {
        emit(
            WebViewNavigator.NavigationEvent.LoadUrl(
                url,
                additionalHttpHeaders
            )
        )
    }

    public override suspend fun loadHtml(
        html: String,
        baseUrl: String?,
        mimeType: String?,
        encoding: String?,
        historyUrl: String?
    ) {
        emit(
            WebViewNavigator.NavigationEvent.LoadHtml(
                html,
                baseUrl,
                mimeType,
                encoding,
                historyUrl
            )
        )
    }

    override suspend fun loadHtmlFile(path: String) {
        emit(WebViewNavigator.NavigationEvent.LoadHtmlFile(path = path))
    }

    public override suspend fun postUrl(
        url: String,
        postData: ByteArray
    ) {
        emit(WebViewNavigator.NavigationEvent.PostUrl(url, postData))
    }

    override suspend fun evaluateJavaScript(script: String, callback: ((String) -> Unit)?) {
        emit(
            WebViewNavigator.NavigationEvent.EvaluateJavaScript(
                script = script,
                callback = callback
            )
        )
    }

    /**
     * Navigates the webview back to the previous page.
     */
    public override suspend fun navigateBack() {
        emit(WebViewNavigator.NavigationEvent.Back)
    }

    /**
     * Navigates the webview forward after going back from a page.
     */
    public override suspend fun navigateForward() {
        emit(WebViewNavigator.NavigationEvent.Forward)
    }

    /**
     * Reloads the current page in the webview.
     */
    public override suspend fun reload() {
        emit(WebViewNavigator.NavigationEvent.Reload)
    }

    /**
     * Stops the current page load (if one is loading).
     */
    public override suspend fun stopLoading() {
        emit(WebViewNavigator.NavigationEvent.StopLoading)
    }

    // Use Dispatchers.Main to ensure that the webview methods are called on UI thread
    internal suspend fun handleNavigationEvents(webView: WebView) {
        withContext(Dispatchers.Main) {
            snapshotFlow { mutableEvent.value }.collect { event ->
                when (event) {
                    is WebViewNavigator.NavigationEvent.Back -> webView.goBack()

                    is WebViewNavigator.NavigationEvent.Forward -> webView.goForward()

                    is WebViewNavigator.NavigationEvent.Reload -> webView.reload()

                    is WebViewNavigator.NavigationEvent.StopLoading -> webView.stopLoading()

                    is WebViewNavigator.NavigationEvent.LoadHtml -> webView.loadDataWithBaseURL(
                        event.baseUrl,
                        event.html,
                        event.mimeType,
                        event.encoding,
                        event.historyUrl
                    )

                    is WebViewNavigator.NavigationEvent.LoadUrl -> {
                        webView.loadUrl(event.url, event.additionalHttpHeaders)
                    }

                    is WebViewNavigator.NavigationEvent.PostUrl -> {
                        webView.postUrl(event.url, event.postData)
                    }

                    is WebViewNavigator.NavigationEvent.EvaluateJavaScript -> webView.evaluateJavascript(
                        event.script,
                        event.callback
                    )

                    is WebViewNavigator.NavigationEvent.LoadHtmlFile -> TODO()
                }
            }
        }
    }

    private suspend fun emit(event: WebViewNavigator.NavigationEvent) {
        mutex.withLock {
            mutableEvent.value = event

            if (mutableRecentEvents.size > 100) { // arbitrary size check to not let the "recent" events get too large
                mutableRecentEvents.removeRange(0, mutableRecentEvents.size / 2)

                mutableRecentEvents.add(event)
            } else {
                mutableRecentEvents.add(event)
            }
        }
    }
}

public val AndroidWebStateSaver: Saver<AndroidWebViewState, Any> = run {
    val pageTitleKey = "pagetitle"
    val lastLoadedUrlKey = "lastloaded"
    val stateBundle = "bundle"

    mapSaver(
        save = {
            val viewState = Bundle().apply { it.webView?.saveState(this) }
            mapOf(
                pageTitleKey to it.pageTitle,
                lastLoadedUrlKey to it.lastLoadedUrl,
                stateBundle to viewState
            )
        },
        restore = {
            AndroidWebViewState(WebContent.NavigatorOnly).apply {
                this.pageTitle = it[pageTitleKey] as String?
                this.lastLoadedUrl = it[lastLoadedUrlKey] as String?
                this.viewState = it[stateBundle] as Bundle?
            }
        }
    )
}
