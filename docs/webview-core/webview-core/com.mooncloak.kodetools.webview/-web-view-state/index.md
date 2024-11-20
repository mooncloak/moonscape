//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[WebViewState](index.md)

# WebViewState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

interface [WebViewState](index.md)

A state holder to hold the state for the WebView. In most cases this will be remembered using the rememberWebViewState(uri) function.

#### Inheritors

| |
|---|
| [AndroidWebViewState](../../../../webview-core/webview-core/com.mooncloak.kodetools.webview/-android-web-view-state/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [content](content.md) | [common]<br>abstract val [content](content.md): [WebContent](../-web-content/index.md)<br>The content being loaded by the WebView |
| [errorsForCurrentRequest](errors-for-current-request.md) | [common]<br>abstract val [errorsForCurrentRequest](errors-for-current-request.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WebViewError](../-web-view-error/index.md)&gt;<br>A list for errors captured in the last load. Reset when a new page is loaded. Errors could be from any resource (iframe, image, etc.), not just for the main page. To filter for only main frame errors, use [WebViewError.isFromMainFrame](../-web-view-error/is-from-main-frame.md). |
| [isLoading](is-loading.md) | [common]<br>open val [isLoading](is-loading.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the webview is currently loading data in its main frame |
| [lastLoadedUrl](last-loaded-url.md) | [common]<br>abstract val [lastLoadedUrl](last-loaded-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The last loaded url. This is updated when a new page is loaded. |
| [loadingState](loading-state.md) | [common]<br>abstract val [loadingState](loading-state.md): [LoadingState](../-loading-state/index.md)<br>Whether the WebView is currently [LoadingState.Loading](../-loading-state/-loading/index.md) data in its main frame (along with progress) or the data loading has [LoadingState.Finished](../-loading-state/-finished/index.md). See [LoadingState](../-loading-state/index.md) |
| [pageTitle](page-title.md) | [common]<br>abstract val [pageTitle](page-title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The title received from the loaded content of the current page |
| [settings](settings.md) | [common]<br>abstract val [settings](settings.md): [WebSettings](../-web-settings/index.md)<br>Custom Settings for WebView. |
