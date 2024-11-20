//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[AndroidWebViewState](index.md)/[errorsForCurrentRequest](errors-for-current-request.md)

# errorsForCurrentRequest

[android]\
open override val [errorsForCurrentRequest](errors-for-current-request.md): [SnapshotStateList](https://developer.android.com/reference/kotlin/androidx/compose/runtime/snapshots/SnapshotStateList.html)&lt;[WebViewError](../-web-view-error/index.md)&gt;

A list for errors captured in the last load. Reset when a new page is loaded. Errors could be from any resource (iframe, image, etc.), not just for the main page. For more fine grained control use the OnError callback of the WebView.
