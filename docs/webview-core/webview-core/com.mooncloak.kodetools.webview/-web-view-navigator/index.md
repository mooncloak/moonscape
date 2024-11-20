//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[WebViewNavigator](index.md)

# WebViewNavigator

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

interface [WebViewNavigator](index.md)

Allows control over the navigation of a WebView from outside the composable. E.g. for performing a back navigation in response to the user clicking the &quot;up&quot; button in a TopAppBar.

#### Inheritors

| |
|---|
| [AndroidWebViewNavigator](../../../../webview-core/webview-core/com.mooncloak.kodetools.webview/-android-web-view-navigator/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [NavigationEvent](-navigation-event/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>sealed interface [NavigationEvent](-navigation-event/index.md)<br>Sealed class for constraining possible navigation events. |

## Properties

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>abstract val [canGoBack](can-go-back.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True when the web view is able to navigate backwards, false otherwise. |
| [canGoForward](can-go-forward.md) | [common]<br>abstract val [canGoForward](can-go-forward.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True when the web view is able to navigate forwards, false otherwise. |
| [event](event.md) | [common]<br>abstract val [event](event.md): [WebViewNavigator.NavigationEvent](-navigation-event/index.md)<br>The latest [NavigationEvent](-navigation-event/index.md). |
| [recentEvents](recent-events.md) | [common]<br>abstract val [recentEvents](recent-events.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WebViewNavigator.NavigationEvent](-navigation-event/index.md)&gt;<br>The recent [NavigationEvent](-navigation-event/index.md)s. |

## Functions

| Name | Summary |
|---|---|
| [evaluateJavaScript](evaluate-java-script.md) | [common]<br>abstract suspend fun [evaluateJavaScript](evaluate-java-script.md)(script: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null)<br>Evaluates the given JavaScript in the context of the currently displayed page. |
| [loadHtml](load-html.md) | [common]<br>abstract suspend fun [loadHtml](load-html.md)(html: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, mimeType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, encoding: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;utf-8&quot;, historyUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)<br>Loads the given HTML string. |
| [loadHtmlFile](load-html-file.md) | [common]<br>abstract suspend fun [loadHtmlFile](load-html-file.md)(path: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [loadUrl](load-url.md) | [common]<br>abstract suspend fun [loadUrl](load-url.md)(url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), additionalHttpHeaders: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyMap())<br>Loads the given URL. |
| [navigateBack](navigate-back.md) | [common]<br>abstract suspend fun [navigateBack](navigate-back.md)()<br>Navigates the webview back to the previous page. |
| [navigateForward](navigate-forward.md) | [common]<br>abstract suspend fun [navigateForward](navigate-forward.md)()<br>Navigates the webview forward after going back from a page. |
| [postUrl](post-url.md) | [common]<br>abstract suspend fun [postUrl](post-url.md)(url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), postData: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html))<br>Posts the given data to the given URL. |
| [reload](reload.md) | [common]<br>abstract suspend fun [reload](reload.md)()<br>Reloads the current page in the webview. |
| [stopLoading](stop-loading.md) | [common]<br>abstract suspend fun [stopLoading](stop-loading.md)()<br>Stops the current page load (if one is loading). |
