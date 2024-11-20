//[webview-core](../../../index.md)/[com.mooncloak.kodetools.webview](../index.md)/[PlatformWebSettings](index.md)

# PlatformWebSettings

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

sealed interface [PlatformWebSettings](index.md)

#### Inheritors

| |
|---|
| [AndroidWebSettings](-android-web-settings/index.md) |
| [DesktopWebSettings](-desktop-web-settings/index.md) |
| [IOSWebSettings](-i-o-s-web-settings/index.md) |

## Types

| Name | Summary |
|---|---|
| [AndroidWebSettings](-android-web-settings/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [AndroidWebSettings](-android-web-settings/index.md)(val allowFileAccess: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val textZoom: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 100, val useWideViewPort: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val standardFontFamily: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;sans-serif&quot;, val defaultFontSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 16, val loadsImagesAutomatically: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val isAlgorithmicDarkeningAllowed: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val safeBrowsingEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val domStorageEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val mediaPlaybackRequiresUserGesture: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val allowProtectedMedia: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val allowMidiSysexMessages: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val hideDefaultVideoPoster: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val layerType: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = LayerType.HARDWARE) : [PlatformWebSettings](index.md)<br>Android web settings. |
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [DesktopWebSettings](-desktop-web-settings/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [DesktopWebSettings](-desktop-web-settings/index.md)(val offScreenRendering: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val transparent: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val disablePopupWindows: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) : [PlatformWebSettings](index.md)<br>Desktop web settings. |
| [IOSWebSettings](-i-o-s-web-settings/index.md) | [common]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [IOSWebSettings](-i-o-s-web-settings/index.md)(val opaque: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val backgroundColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)? = null, val underPageBackgroundColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)? = null, val bounces: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val scrollEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val showHorizontalScrollIndicator: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val showVerticalScrollIndicator: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val mediaPlaybackRequiresUserGesture: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : [PlatformWebSettings](index.md)<br>IOS web settings. |
