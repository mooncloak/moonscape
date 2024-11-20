//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[WebViewComponentFactory](index.md)

# WebViewComponentFactory

interface [WebViewComponentFactory](index.md)&lt;[State](index.md) : [WebViewState](../-web-view-state/index.md), [Navigator](index.md) : [WebViewNavigator](../-web-view-navigator/index.md)&gt;

#### Inheritors

| |
|---|
| [AndroidWebViewComponentFactory](../../../../webview-core/webview-core/com.mooncloak.kodetools.webview/-android-web-view-component-factory/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [createWebViewContentProvider](create-web-view-content-provider.md) | [common]<br>abstract fun [createWebViewContentProvider](create-web-view-content-provider.md)(): [WebViewContentProvider](../-web-view-content-provider/index.md)&lt;[State](index.md), [Navigator](index.md)&gt; |
| [createWebViewNavigator](create-web-view-navigator.md) | [common]<br>abstract fun [createWebViewNavigator](create-web-view-navigator.md)(): [Navigator](index.md) |
| [createWebViewState](create-web-view-state.md) | [common]<br>abstract fun [createWebViewState](create-web-view-state.md)(content: [WebContent](../-web-content/index.md)? = null): [State](index.md) |
| [createWebViewStateSaver](create-web-view-state-saver.md) | [common]<br>abstract fun [createWebViewStateSaver](create-web-view-state-saver.md)(): [Saver](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/Saver.html)&lt;[State](index.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;? |
