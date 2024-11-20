//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[WebViewNavigator](index.md)/[loadHtml](load-html.md)

# loadHtml

[common]\
abstract suspend fun [loadHtml](load-html.md)(html: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, mimeType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, encoding: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = &quot;utf-8&quot;, historyUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)

Loads the given HTML string.

#### Parameters

common

| | |
|---|---|
| html | The HTML string to load. |
| baseUrl | The URL to use as the page's base URL. |
| mimeType | The MIME type of the data in the string. |
| encoding | The encoding of the data in the string. |
| historyUrl | The history URL for the loaded HTML. Leave null to use about:blank. |
