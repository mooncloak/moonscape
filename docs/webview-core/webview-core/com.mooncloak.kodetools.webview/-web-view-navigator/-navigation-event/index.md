//[webview-core](../../../../index.md)/[com.mooncloak.kodetools.webview](../../index.md)/[WebViewNavigator](../index.md)/[NavigationEvent](index.md)

# NavigationEvent

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

sealed interface [NavigationEvent](index.md)

Sealed class for constraining possible navigation events.

#### Inheritors

| |
|---|
| [Back](-back/index.md) |
| [Forward](-forward/index.md) |
| [Reload](-reload/index.md) |
| [StopLoading](-stop-loading/index.md) |
| [LoadUrl](-load-url/index.md) |
| [LoadHtml](-load-html/index.md) |
| [LoadHtmlFile](-load-html-file/index.md) |
| [PostUrl](-post-url/index.md) |
| [EvaluateJavaScript](-evaluate-java-script/index.md) |

## Types

| Name | Summary |
|---|---|
| [Back](-back/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data object [Back](-back/index.md) : [WebViewNavigator.NavigationEvent](index.md)<br>Navigate back event. |
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [EvaluateJavaScript](-evaluate-java-script/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [EvaluateJavaScript](-evaluate-java-script/index.md)(val script: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val callback: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?) : [WebViewNavigator.NavigationEvent](index.md)<br>Evaluate javascript event. |
| [Forward](-forward/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data object [Forward](-forward/index.md) : [WebViewNavigator.NavigationEvent](index.md)<br>Navigate forward event. |
| [LoadHtml](-load-html/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [LoadHtml](-load-html/index.md)(val html: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val mimeType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val encoding: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;utf-8&quot;, val historyUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [WebViewNavigator.NavigationEvent](index.md)<br>Load html event. |
| [LoadHtmlFile](-load-html-file/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [LoadHtmlFile](-load-html-file/index.md)(val path: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [WebViewNavigator.NavigationEvent](index.md) |
| [LoadUrl](-load-url/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [LoadUrl](-load-url/index.md)(val url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val additionalHttpHeaders: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyMap()) : [WebViewNavigator.NavigationEvent](index.md)<br>Load url event. |
| [PostUrl](-post-url/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [PostUrl](-post-url/index.md)(val url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val postData: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)) : [WebViewNavigator.NavigationEvent](index.md)<br>Post url event. |
| [Reload](-reload/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data object [Reload](-reload/index.md) : [WebViewNavigator.NavigationEvent](index.md)<br>Reload event. |
| [StopLoading](-stop-loading/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data object [StopLoading](-stop-loading/index.md) : [WebViewNavigator.NavigationEvent](index.md)<br>Stop loading event. |
