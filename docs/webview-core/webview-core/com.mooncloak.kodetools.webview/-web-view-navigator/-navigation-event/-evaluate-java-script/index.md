//[webview-core](../../../../../index.md)/[com.mooncloak.kodetools.webview](../../../index.md)/[WebViewNavigator](../../index.md)/[NavigationEvent](../index.md)/[EvaluateJavaScript](index.md)

# EvaluateJavaScript

[common]\
@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [EvaluateJavaScript](index.md)(val script: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val callback: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?) : [WebViewNavigator.NavigationEvent](../index.md)

Evaluate javascript event.

## Constructors

| | |
|---|---|
| [EvaluateJavaScript](-evaluate-java-script.md) | [common]<br>constructor(script: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [callback](callback.md) | [common]<br>val [callback](callback.md): ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? |
| [script](script.md) | [common]<br>val [script](script.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
