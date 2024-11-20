//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[WebContent](index.md)

# WebContent

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

sealed interface [WebContent](index.md)

Sealed class for constraining possible web content.

#### Inheritors

| |
|---|
| [Url](-url/index.md) |
| [Data](-data/index.md) |
| [File](-file/index.md) |
| [Post](-post/index.md) |
| [NavigatorOnly](-navigator-only/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [Data](-data/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [Data](-data/index.md)(val data: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val encoding: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;utf-8&quot;, val mimeType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val historyUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [WebContent](index.md)<br>Data content |
| [File](-file/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [File](-file/index.md)(val path: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [WebContent](index.md) |
| [NavigatorOnly](-navigator-only/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data object [NavigatorOnly](-navigator-only/index.md) : [WebContent](index.md) |
| [Post](-post/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [Post](-post/index.md)(val url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val postData: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)) : [WebContent](index.md)<br>Post content |
| [Url](-url/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [Url](-url/index.md)(val url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val additionalHttpHeaders: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyMap()) : [WebContent](index.md)<br>Url content |

## Properties

| Name | Summary |
|---|---|
| [currentUrl](current-url.md) | [common]<br>abstract val [currentUrl](current-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
