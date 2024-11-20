//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[WebViewState](index.md)/[errorsForCurrentRequest](errors-for-current-request.md)

# errorsForCurrentRequest

[common]\
abstract val [errorsForCurrentRequest](errors-for-current-request.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WebViewError](../-web-view-error/index.md)&gt;

A list for errors captured in the last load. Reset when a new page is loaded. Errors could be from any resource (iframe, image, etc.), not just for the main page. To filter for only main frame errors, use [WebViewError.isFromMainFrame](../-web-view-error/is-from-main-frame.md).
