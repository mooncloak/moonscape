//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[AndroidWebViewComponentFactory](index.md)

# AndroidWebViewComponentFactory

[android]\
class [AndroidWebViewComponentFactory](index.md)(webViewClientFactory: () -&gt; [AndroidWebViewClient](../-android-web-view-client/index.md) = { AndroidWebViewClient() }, webChromeClientFactory: () -&gt; [AndroidWebChromeClient](../-android-web-chrome-client/index.md) = { AndroidWebChromeClient() }) : [WebViewComponentFactory](../-web-view-component-factory/index.md)&lt;[AndroidWebViewState](../-android-web-view-state/index.md), [AndroidWebViewNavigator](../-android-web-view-navigator/index.md)&gt;

## Constructors

| | |
|---|---|
| [AndroidWebViewComponentFactory](-android-web-view-component-factory.md) | [android]<br>constructor(webViewClientFactory: () -&gt; [AndroidWebViewClient](../-android-web-view-client/index.md) = { AndroidWebViewClient() }, webChromeClientFactory: () -&gt; [AndroidWebChromeClient](../-android-web-chrome-client/index.md) = { AndroidWebChromeClient() }) |

## Functions

| Name | Summary |
|---|---|
| [createWebViewContentProvider](create-web-view-content-provider.md) | [android]<br>open override fun [createWebViewContentProvider](create-web-view-content-provider.md)(): [WebViewContentProvider](../-web-view-content-provider/index.md)&lt;[AndroidWebViewState](../-android-web-view-state/index.md), [AndroidWebViewNavigator](../-android-web-view-navigator/index.md)&gt; |
| [createWebViewNavigator](create-web-view-navigator.md) | [android]<br>open override fun [createWebViewNavigator](create-web-view-navigator.md)(): [AndroidWebViewNavigator](../-android-web-view-navigator/index.md) |
| [createWebViewState](create-web-view-state.md) | [android]<br>open override fun [createWebViewState](create-web-view-state.md)(content: [WebContent](../-web-content/index.md)?): [AndroidWebViewState](../-android-web-view-state/index.md) |
| [createWebViewStateSaver](create-web-view-state-saver.md) | [android]<br>open override fun [createWebViewStateSaver](create-web-view-state-saver.md)(): [Saver](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/Saver.html)&lt;[AndroidWebViewState](../-android-web-view-state/index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |
