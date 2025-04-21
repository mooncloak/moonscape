package com.mooncloak.moonscape.webview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

/**
 * A state holder to hold the state for the WebView. In most cases this will be remembered
 * using the rememberWebViewState(uri) function.
 */
@Stable
public interface WebViewState {

    /**
     * The last loaded url. This is updated when a new page is loaded.
     */
    public val lastLoadedUrl: String?

    /**
     *  The content being loaded by the WebView
     */
    public val content: WebContent

    /**
     * Whether the WebView is currently [LoadingState.Loading] data in its main frame (along with
     * progress) or the data loading has [LoadingState.Finished]. See [LoadingState]
     */
    public val loadingState: LoadingState

    /**
     * Whether the webview is currently loading data in its main frame
     */
    public val isLoading: Boolean
        get() = loadingState !is LoadingState.Finished

    /**
     * The title received from the loaded content of the current page
     */
    public val pageTitle: String?

    /**
     * A list for errors captured in the last load. Reset when a new page is loaded.
     * Errors could be from any resource (iframe, image, etc.), not just for the main page.
     * To filter for only main frame errors, use [WebViewError.isFromMainFrame].
     */
    public val errorsForCurrentRequest: List<WebViewError>

    /**
     * Custom Settings for WebView.
     */
    public val settings: WebSettings

    public companion object
}

@Composable
public fun rememberWebViewState(content: WebContent? = null): WebViewState {
    val factory = LocalWebViewComponentFactory.current
    val saver = factory.createWebViewStateSaver()

    return if (saver == null) {
        remember(content) { factory.createWebViewState(content = content) }
    } else {
        rememberSaveable(saver) { factory.createWebViewState(content = content) }
    }
}
