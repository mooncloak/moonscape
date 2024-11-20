//[webview-core](../../index.md)/[com.mooncloak.kodetools.webview](index.md)/[WebView](-web-view.md)

# WebView

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [WebView](-web-view.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, state: [WebViewState](-web-view-state/index.md) = rememberWebViewState(), navigator: [WebViewNavigator](-web-view-navigator/index.md) = rememberWebViewNavigator(), captureBackPresses: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)

@[JvmName](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-name/index.html)(name = &quot;WebViewGeneric&quot;)

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

inline fun &lt;[State](-web-view.md) : [WebViewState](-web-view-state/index.md), [Navigator](-web-view.md) : [WebViewNavigator](-web-view-navigator/index.md)&gt; [WebView](-web-view.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, state: [State](-web-view.md), navigator: [Navigator](-web-view.md), captureBackPresses: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)
