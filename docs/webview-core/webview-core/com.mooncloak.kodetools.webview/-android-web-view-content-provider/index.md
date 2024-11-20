//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[AndroidWebViewContentProvider](index.md)

# AndroidWebViewContentProvider

[android]\
class [AndroidWebViewContentProvider](index.md)(webViewClientFactory: () -&gt; [AndroidWebViewClient](../-android-web-view-client/index.md) = { AndroidWebViewClient() }, webChromeClientFactory: () -&gt; [AndroidWebChromeClient](../-android-web-chrome-client/index.md) = { AndroidWebChromeClient() }) : [WebViewContentProvider](../-web-view-content-provider/index.md)&lt;[AndroidWebViewState](../-android-web-view-state/index.md), [AndroidWebViewNavigator](../-android-web-view-navigator/index.md)&gt;

## Constructors

| | |
|---|---|
| [AndroidWebViewContentProvider](-android-web-view-content-provider.md) | [android]<br>constructor(webViewClientFactory: () -&gt; [AndroidWebViewClient](../-android-web-view-client/index.md) = { AndroidWebViewClient() }, webChromeClientFactory: () -&gt; [AndroidWebChromeClient](../-android-web-chrome-client/index.md) = { AndroidWebChromeClient() }) |

## Functions

| Name | Summary |
|---|---|
| [Content](-content.md) | [android]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>open override fun [Content](-content.md)(state: [AndroidWebViewState](../-android-web-view-state/index.md), navigator: [AndroidWebViewNavigator](../-android-web-view-navigator/index.md), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html), captureBackPresses: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
