//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[LoadingState](index.md)

# LoadingState

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

sealed interface [LoadingState](index.md)

Sealed class for constraining possible loading states. See [Initializing](-initializing/index.md), [Loading](-loading/index.md), and [Finished](-finished/index.md).

#### Inheritors

| |
|---|
| [Initializing](-initializing/index.md) |
| [Loading](-loading/index.md) |
| [Finished](-finished/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [Finished](-finished/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data object [Finished](-finished/index.md) : [LoadingState](index.md)<br>Describes a webview that has finished loading content. |
| [Initializing](-initializing/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data object [Initializing](-initializing/index.md) : [LoadingState](index.md)<br>Describes a WebView that has not yet loaded for the first time. |
| [Loading](-loading/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [Loading](-loading/index.md)(val progress: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)? = null) : [LoadingState](index.md)<br>Describes a webview between `onPageStarted` and `onPageFinished` events, contains a [progress](-loading/progress.md) property which is updated by the webview. |
