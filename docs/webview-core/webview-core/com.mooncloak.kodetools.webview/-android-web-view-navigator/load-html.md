//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[AndroidWebViewNavigator](index.md)/[loadHtml](load-html.md)

# loadHtml

[android]\
open suspend override fun [loadHtml](load-html.md)(html: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, mimeType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, encoding: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, historyUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

Loads the given HTML string.

#### Parameters

android

| | |
|---|---|
| html | The HTML string to load. |
| baseUrl | The URL to use as the page's base URL. |
| mimeType | The MIME type of the data in the string. |
| encoding | The encoding of the data in the string. |
| historyUrl | The history URL for the loaded HTML. Leave null to use about:blank. |
