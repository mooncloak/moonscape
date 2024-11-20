//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[AndroidWebViewState](index.md)

# AndroidWebViewState

[android]\
@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

class [AndroidWebViewState](index.md)(webContent: [WebContent](../-web-content/index.md) = WebContent.NavigatorOnly, settings: [WebSettings](../-web-settings/index.md) = WebSettings()) : [WebViewState](../-web-view-state/index.md)

## Constructors

| | |
|---|---|
| [AndroidWebViewState](-android-web-view-state.md) | [android]<br>constructor(webContent: [WebContent](../-web-content/index.md) = WebContent.NavigatorOnly, settings: [WebSettings](../-web-settings/index.md) = WebSettings()) |

## Properties

| Name | Summary |
|---|---|
| [content](content.md) | [android]<br>open override var [content](content.md): [WebContent](../-web-content/index.md)<br>The content being loaded by the WebView |
| [errorsForCurrentRequest](errors-for-current-request.md) | [android]<br>open override val [errorsForCurrentRequest](errors-for-current-request.md): [SnapshotStateList](https://developer.android.com/reference/kotlin/androidx/compose/runtime/snapshots/SnapshotStateList.html)&lt;[WebViewError](../-web-view-error/index.md)&gt;<br>A list for errors captured in the last load. Reset when a new page is loaded. Errors could be from any resource (iframe, image, etc.), not just for the main page. For more fine grained control use the OnError callback of the WebView. |
| [isLoading](../-web-view-state/is-loading.md) | [android]<br>open val [isLoading](../-web-view-state/is-loading.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the webview is currently loading data in its main frame |
| [lastLoadedUrl](last-loaded-url.md) | [android]<br>open override var [lastLoadedUrl](last-loaded-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The last loaded url. This is updated when a new page is loaded. |
| [loadingState](loading-state.md) | [android]<br>open override var [loadingState](loading-state.md): [LoadingState](../-loading-state/index.md)<br>Whether the WebView is currently [LoadingState.Loading](../-loading-state/-loading/index.md) data in its main frame (along with progress) or the data loading has [LoadingState.Finished](../-loading-state/-finished/index.md). See [LoadingState](../-loading-state/index.md) |
| [pageIcon](page-icon.md) | [android]<br>var [pageIcon](page-icon.md): [Bitmap](https://developer.android.com/reference/kotlin/android/graphics/Bitmap.html)?<br>the favicon received from the loaded content of the current page |
| [pageTitle](page-title.md) | [android]<br>open override var [pageTitle](page-title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The title received from the loaded content of the current page |
| [settings](settings.md) | [android]<br>open override var [settings](settings.md): [WebSettings](../-web-settings/index.md)<br>Custom Settings for WebView. |
| [viewState](view-state.md) | [android]<br>var [viewState](view-state.md): [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?<br>The saved view state from when the view was destroyed last. To restore state, use the navigator and only call loadUrl if the bundle is null. See WebViewSaveStateSample. |
