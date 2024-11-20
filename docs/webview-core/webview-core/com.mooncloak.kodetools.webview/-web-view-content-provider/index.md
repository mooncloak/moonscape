//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[WebViewContentProvider](index.md)

# WebViewContentProvider

fun interface [WebViewContentProvider](index.md)&lt;[State](index.md) : [WebViewState](../-web-view-state/index.md), [Navigator](index.md) : [WebViewNavigator](../-web-view-navigator/index.md)&gt;

#### Inheritors

| |
|---|
| [AndroidWebViewContentProvider](../../../../webview-core/webview-core/com.mooncloak.kodetools.webview/-android-web-view-content-provider/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [Content](-content.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>abstract fun [Content](-content.md)(state: [State](index.md), navigator: [Navigator](index.md), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html), captureBackPresses: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
