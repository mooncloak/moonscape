//[webview-core](../../../../index.md)/[com.mooncloak.kodetools.webview](../../index.md)/[WebContent](../index.md)/[Url](index.md)

# Url

[common]\
@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [Url](index.md)(val url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val additionalHttpHeaders: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyMap()) : [WebContent](../index.md)

Url content

## Constructors

| | |
|---|---|
| [Url](-url.md) | [common]<br>constructor(url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), additionalHttpHeaders: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyMap()) |

## Properties

| Name | Summary |
|---|---|
| [additionalHttpHeaders](additional-http-headers.md) | [common]<br>val [additionalHttpHeaders](additional-http-headers.md): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [currentUrl](current-url.md) | [common]<br>open override val [currentUrl](current-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [url](url.md) | [common]<br>val [url](url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
