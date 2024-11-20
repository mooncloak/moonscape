//[webview-core](../../../../index.md)/[com.mooncloak.kodetools.webview](../../index.md)/[PlatformWebSettings](../index.md)/[IOSWebSettings](index.md)

# IOSWebSettings

[common]\
@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [IOSWebSettings](index.md)(val opaque: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val backgroundColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)? = null, val underPageBackgroundColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)? = null, val bounces: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val scrollEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val showHorizontalScrollIndicator: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val showVerticalScrollIndicator: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val mediaPlaybackRequiresUserGesture: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : [PlatformWebSettings](../index.md)

IOS web settings.

## Constructors

| | |
|---|---|
| [IOSWebSettings](-i-o-s-web-settings.md) | [common]<br>constructor(opaque: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, backgroundColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)? = null, underPageBackgroundColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)? = null, bounces: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, scrollEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, showHorizontalScrollIndicator: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, showVerticalScrollIndicator: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, mediaPlaybackRequiresUserGesture: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |

## Properties

| Name | Summary |
|---|---|
| [backgroundColor](background-color.md) | [common]<br>val [backgroundColor](background-color.md): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)? = null<br>The background color of the WebView client. The default value is {@code null}. Will use WebSettings backgroundColor when null. |
| [bounces](bounces.md) | [common]<br>val [bounces](bounces.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>Whether the WebView bounces when scrolled past content bounds. The default value is `true`. |
| [mediaPlaybackRequiresUserGesture](media-playback-requires-user-gesture.md) | [common]<br>val [mediaPlaybackRequiresUserGesture](media-playback-requires-user-gesture.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>Whether a user gesture is required to play media. The default is `true`. |
| [opaque](opaque.md) | [common]<br>val [opaque](opaque.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>The ios default opaque display The default value is {@code false}. When Value is true will turn off these two properties: @param backgroundColor,@param underPageBackgroundColor |
| [scrollEnabled](scroll-enabled.md) | [common]<br>val [scrollEnabled](scroll-enabled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>Whether horizontal and vertical scrolling is enabled. The default value is `true`. |
| [showHorizontalScrollIndicator](show-horizontal-scroll-indicator.md) | [common]<br>val [showHorizontalScrollIndicator](show-horizontal-scroll-indicator.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>Whether the horizontal scroll indicator is visible. The default value is `true`. |
| [showVerticalScrollIndicator](show-vertical-scroll-indicator.md) | [common]<br>val [showVerticalScrollIndicator](show-vertical-scroll-indicator.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>Whether the vertical scroll indicator is visible. The default value is `true`. |
| [underPageBackgroundColor](under-page-background-color.md) | [common]<br>val [underPageBackgroundColor](under-page-background-color.md): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)? = null<br>The background color shown when the WebView client scrolls past the bounds of the active page. The default value is `null`. Will use WebSettings backgroundColor when null. |
