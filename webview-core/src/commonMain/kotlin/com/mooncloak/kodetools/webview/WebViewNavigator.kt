package com.mooncloak.kodetools.webview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember

/**
 * Allows control over the navigation of a WebView from outside the composable. E.g. for performing
 * a back navigation in response to the user clicking the "up" button in a TopAppBar.
 */
@Stable
public interface WebViewNavigator {

    /**
     * The latest [NavigationEvent].
     */
    public val event: NavigationEvent

    /**
     * The recent [NavigationEvent]s.
     */
    public val recentEvents: List<NavigationEvent>

    /**
     * True when the web view is able to navigate backwards, false otherwise.
     */
    public val canGoBack: Boolean

    /**
     * True when the web view is able to navigate forwards, false otherwise.
     */
    public val canGoForward: Boolean

    /**
     * Loads the given URL.
     *
     * @param url The URL of the resource to load.
     */
    public suspend fun loadUrl(
        url: String,
        additionalHttpHeaders: Map<String, String> = emptyMap(),
    )

    /**
     * Loads the given HTML string.
     *
     * @param html The HTML string to load.
     * @param baseUrl The URL to use as the page's base URL.
     * @param mimeType The MIME type of the data in the string.
     * @param encoding The encoding of the data in the string.
     * @param historyUrl The history URL for the loaded HTML. Leave null to use about:blank.
     */
    public suspend fun loadHtml(
        html: String,
        baseUrl: String? = null,
        mimeType: String? = null,
        encoding: String? = "utf-8",
        historyUrl: String? = null,
    )

    public suspend fun loadHtmlFile(path: String)

    /**
     * Posts the given data to the given URL.
     *
     * @param url The URL to post the data to.
     * @param postData The data to post.
     */
    public suspend fun postUrl(
        url: String,
        postData: ByteArray,
    )

    /**
     * Evaluates the given JavaScript in the context of the currently displayed page.
     *
     * @param script The JavaScript to evaluate.
     * @param callback A callback to be invoked when the script execution completes.
     */
    public suspend fun evaluateJavaScript(
        script: String,
        callback: ((String) -> Unit)? = null,
    )

    /**
     * Navigates the webview back to the previous page.
     */
    public suspend fun navigateBack()

    /**
     * Navigates the webview forward after going back from a page.
     */
    public suspend fun navigateForward()

    /**
     * Reloads the current page in the webview.
     */
    public suspend fun reload()

    /**
     * Stops the current page load (if one is loading).
     */
    public suspend fun stopLoading()

    /**
     * Sealed class for constraining possible navigation events.
     */
    public sealed interface NavigationEvent {

        /**
         * Navigate back event.
         */
        public data object Back : NavigationEvent

        /**
         * Navigate forward event.
         */
        public data object Forward : NavigationEvent

        /**
         * Reload event.
         */
        public data object Reload : NavigationEvent

        /**
         * Stop loading event.
         */
        public data object StopLoading : NavigationEvent

        /**
         * Load url event.
         */
        public data class LoadUrl public constructor(
            public val url: String,
            public val additionalHttpHeaders: Map<String, String> = emptyMap(),
        ) : NavigationEvent

        /**
         * Load html event.
         */
        public data class LoadHtml public constructor(
            public val html: String,
            public val baseUrl: String? = null,
            public val mimeType: String? = null,
            public val encoding: String? = "utf-8",
            public val historyUrl: String? = null,
        ) : NavigationEvent

        public data class LoadHtmlFile public constructor(
            val fileName: String,
        ) : NavigationEvent

        /**
         * Post url event.
         */
        public data class PostUrl public constructor(
            public val url: String,
            public val postData: ByteArray,
        ) : NavigationEvent {

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || this::class != other::class) return false

                other as PostUrl

                if (url != other.url) return false
                if (!postData.contentEquals(other.postData)) return false

                return true
            }

            override fun hashCode(): Int {
                var result = url.hashCode()
                result = 31 * result + postData.contentHashCode()
                return result
            }
        }

        /**
         * Evaluate javascript event.
         */
        public data class EvaluateJavaScript public constructor(
            public val script: String,
            public val callback: ((String) -> Unit)?,
        ) : NavigationEvent

        public companion object
    }

    public companion object
}

@Composable
public fun rememberWebViewNavigator(): WebViewNavigator {
    val factory = LocalWebViewComponentFactory.current

    return remember { factory.createWebViewNavigator() }
}
