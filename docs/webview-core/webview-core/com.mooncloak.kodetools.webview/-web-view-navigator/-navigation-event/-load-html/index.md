//[webview-core](../../../../../index.md)/[com.mooncloak.kodetools.webview](../../../index.md)/[WebViewNavigator](../../index.md)/[NavigationEvent](../index.md)/[LoadHtml](index.md)

# LoadHtml

[common]\
@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [LoadHtml](index.md)(val html: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val mimeType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val encoding: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;utf-8&quot;, val historyUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [WebViewNavigator.NavigationEvent](../index.md)

Load html event.

## Constructors

| | |
|---|---|
| [LoadHtml](-load-html.md) | [common]<br>constructor(html: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, mimeType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, encoding: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;utf-8&quot;, historyUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [baseUrl](base-url.md) | [common]<br>val [baseUrl](base-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [encoding](encoding.md) | [common]<br>val [encoding](encoding.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [historyUrl](history-url.md) | [common]<br>val [historyUrl](history-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [html](html.md) | [common]<br>val [html](html.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [mimeType](mime-type.md) | [common]<br>val [mimeType](mime-type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
