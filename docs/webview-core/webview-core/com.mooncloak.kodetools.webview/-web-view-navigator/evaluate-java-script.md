//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[WebViewNavigator](index.md)/[evaluateJavaScript](evaluate-java-script.md)

# evaluateJavaScript

[common]\
abstract suspend fun [evaluateJavaScript](evaluate-java-script.md)(script: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null)

Evaluates the given JavaScript in the context of the currently displayed page.

#### Parameters

common

| | |
|---|---|
| script | The JavaScript to evaluate. |
| callback | A callback to be invoked when the script execution completes. |
