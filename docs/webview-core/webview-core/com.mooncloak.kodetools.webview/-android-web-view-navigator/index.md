//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[AndroidWebViewNavigator](index.md)

# AndroidWebViewNavigator

[android]\
class [AndroidWebViewNavigator](index.md)(initialEvent: [WebViewNavigator.NavigationEvent](../-web-view-navigator/-navigation-event/index.md)) : [WebViewNavigator](../-web-view-navigator/index.md)

## Constructors

| | |
|---|---|
| [AndroidWebViewNavigator](-android-web-view-navigator.md) | [android]<br>constructor(initialEvent: [WebViewNavigator.NavigationEvent](../-web-view-navigator/-navigation-event/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [android]<br>open override var [canGoBack](can-go-back.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True when the web view is able to navigate backwards, false otherwise. |
| [canGoForward](can-go-forward.md) | [android]<br>open override var [canGoForward](can-go-forward.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True when the web view is able to navigate forwards, false otherwise. |
| [event](event.md) | [android]<br>open override val [event](event.md): [WebViewNavigator.NavigationEvent](../-web-view-navigator/-navigation-event/index.md)<br>The latest NavigationEvent. |
| [recentEvents](recent-events.md) | [android]<br>open override val [recentEvents](recent-events.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WebViewNavigator.NavigationEvent](../-web-view-navigator/-navigation-event/index.md)&gt;<br>The recent NavigationEvents. |

## Functions

| Name | Summary |
|---|---|
| [evaluateJavaScript](evaluate-java-script.md) | [android]<br>open suspend override fun [evaluateJavaScript](evaluate-java-script.md)(script: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)<br>Evaluates the given JavaScript in the context of the currently displayed page. |
| [loadHtml](load-html.md) | [android]<br>open suspend override fun [loadHtml](load-html.md)(html: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, mimeType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, encoding: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, historyUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)<br>Loads the given HTML string. |
| [loadHtmlFile](load-html-file.md) | [android]<br>open suspend override fun [loadHtmlFile](load-html-file.md)(path: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [loadUrl](load-url.md) | [android]<br>open suspend override fun [loadUrl](load-url.md)(url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), additionalHttpHeaders: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;)<br>Loads the given URL. |
| [navigateBack](navigate-back.md) | [android]<br>open suspend override fun [navigateBack](navigate-back.md)()<br>Navigates the webview back to the previous page. |
| [navigateForward](navigate-forward.md) | [android]<br>open suspend override fun [navigateForward](navigate-forward.md)()<br>Navigates the webview forward after going back from a page. |
| [postUrl](post-url.md) | [android]<br>open suspend override fun [postUrl](post-url.md)(url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), postData: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html))<br>Posts the given data to the given URL. |
| [reload](reload.md) | [android]<br>open suspend override fun [reload](reload.md)()<br>Reloads the current page in the webview. |
| [stopLoading](stop-loading.md) | [android]<br>open suspend override fun [stopLoading](stop-loading.md)()<br>Stops the current page load (if one is loading). |
