package com.mooncloak.kodetools.webview

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
public sealed interface PlatformWebSettings {

    /**
     * Android web settings.
     *
     * @property [allowFileAccess] Enables or disables file access within WebView. Note that this enables or disables
     * file system access only. Assets and resources are still accessible using
     * file:///android_asset and file:///android_res.
     * <p class="note">
     * <b>Note:</b> Apps should not open {@code file://} URLs from any external source in
     * WebView, don't enable this if your app accepts arbitrary URLs from external sources.
     * It's recommended to always use
     * <a href="{@docRoot}reference/androidx/webkit/WebViewAssetLoader">
     * androidx.webkit.WebViewAssetLoader</a> to access files including assets and resources over
     * {@code http(s)://} schemes, instead of {@code file://} URLs. To prevent possible security
     * issues targeting {@link android.os.Build.VERSION_CODES#Q} and earlier, you should explicitly
     * set this value to {@code false}.
     * <p>
     * The default value is {@code true} for apps targeting
     * {@link android.os.Build.VERSION_CODES#Q} and below, and {@code false} when targeting
     * {@link android.os.Build.VERSION_CODES#R} and above.
     *
     * @property [textZoom] The text zoom of the page in percent. The default is 100.
     *
     * @property [useWideViewPort] Whether the WebView should enable support for the &quot;viewport&quot; HTML meta tag
     * or should use a wide viewport. When the value of the setting is {@code false}, the layout width is always set to
     * the width of the WebView control in device-independent (CSS) pixels. When the value is {@code true} and the page
     * contains the viewport meta tag, the value of the width specified in the tag is used. If the page does not
     * contain the tag or does not provide a width, then a wide viewport will be used.
     *
     * @property [standardFontFamily] The standard font family name. The default is "sans-serif".
     *
     * @property [defaultFontSize] The default font size. The default is 16. A non-negative integer between 1 and 72.
     * Any number outside the specified range will be pinned.
     *
     * @property [loadsImagesAutomatically] Sets whether the WebView should load image resources. Note that this method
     * controls loading of all images, including those embedded using the data URI scheme. Use
     * {@link #setBlockNetworkImage} to control loading only of images specified using network URI schemes. Note that
     * if the value of this setting is changed from {@code false} to {@code true}, all images resources referenced by
     * content currently displayed by the WebView are loaded automatically. The default is {@code true}.
     *
     * @property [isAlgorithmicDarkeningAllowed] Control whether algorithmic darkening is allowed.
     * <p class="note">
     * <b>Note:</b> This API and the behaviour described only apply to apps with
     * {@code targetSdkVersion} &ge; {@link android.os.Build.VERSION_CODES#TIRAMISU}.
     * <p>
     * WebView always sets the media query {@code prefers-color-scheme} according to the app's
     * theme attribute {@link android.R.styleable#Theme_isLightTheme isLightTheme}, i.e.
     * {@code prefers-color-scheme} is {@code light} if isLightTheme is true or not specified,
     * otherwise it is {@code dark}. This means that the web content's light or dark style will
     * be applied automatically to match the app's theme if the content supports it.
     *
     * <p>
     * Algorithmic darkening is disallowed by default.
     * <p>
     * If the app's theme is dark and it allows algorithmic darkening, WebView will attempt to
     * darken web content using an algorithm, if the content doesn't define its own dark styles
     * and doesn't explicitly disable darkening.
     *
     * <p>
     * If Android is applying Force Dark to WebView then WebView will ignore the value of
     * this setting and behave as if it were set to true.
     *
     * <p>
     * The deprecated {@link #setForceDark} and related API are no-ops in apps with
     * {@code targetSdkVersion} &ge; {@link android.os.Build.VERSION_CODES#TIRAMISU},
     * but they still apply to apps with
     * {@code targetSdkVersion} &lt; {@link android.os.Build.VERSION_CODES#TIRAMISU}.
     *
     * <p>
     * The below table summarizes how APIs work with different apps.
     *
     * <table border="2" width="85%" align="center" cellpadding="5">
     *     <thead>
     *         <tr>
     *             <th>App</th>
     *             <th>Web content which uses {@code prefers-color-scheme}</th>
     *             <th>Web content which does not use {@code prefers-color-scheme}</th>
     *         </tr>
     *     </thead>
     *     <tbody>
     *     <tr>
     *         <td>App with {@code isLightTheme} True or not set</td>
     *         <td>Renders with the light theme defined by the content author.</td>
     *         <td>Renders with the default styling defined by the content author.</td>
     *     </tr>
     *     <tr>
     *         <td>App with Android forceDark in effect</td>
     *         <td>Renders with the dark theme defined by the content author.</td>
     *         <td>Renders with the styling modified to dark colors by an algorithm
     *             if allowed by the content author.</td>
     *     </tr>
     *     <tr>
     *         <td>App with {@code isLightTheme} False,
     *            {@code targetSdkVersion} &lt; {@link android.os.Build.VERSION_CODES#TIRAMISU},
     *             and has {@code FORCE_DARK_AUTO}</td>
     *         <td>Renders with the dark theme defined by the content author.</td>
     *         <td>Renders with the default styling defined by the content author.</td>
     *     </tr>
     *     <tr>
     *         <td>App with {@code isLightTheme} False,
     *            {@code targetSdkVersion} &ge; {@link android.os.Build.VERSION_CODES#TIRAMISU},
     *             and {@code setAlgorithmicDarkening(false)}</td>
     *         <td>Renders with the dark theme defined by the content author.</td>
     *         <td>Renders with the default styling defined by the content author.</td>
     *     </tr>
     *     <tr>
     *         <td>App with {@code isLightTheme} False,
     *            {@code targetSdkVersion} &ge; {@link android.os.Build.VERSION_CODES#TIRAMISU},
     *             and {@code setAlgorithmicDarkening(true)}</td>
     *         <td>Renders with the dark theme defined by the content author.</td>
     *         <td>Renders with the styling modified to dark colors by an algorithm if allowed
     *             by the content author.</td>
     *     </tr>
     *     </tbody>
     * </table>
     * </p>
     *
     * @property [safeBrowsingEnabled] Whether Safe Browsing is enabled. Safe Browsing allows WebView to protect
     * against malware and phishing attacks by verifying the links.
     *
     * @property [domStorageEnabled] Whether the DOM storage API is enabled. The default value is {@code false}.
     *
     * @property [mediaPlaybackRequiresUserGesture] Whether the a user gesture is required to play media. The default
     * is {@code true}.
     *
     * @property [allowProtectedMedia] Controls whether the `RESOURCE_PROTECTED_MEDIA_ID` permission requests should be
     * automatically granted or not. Necessary to be able to play back DRM protected media inside the WebView. The
     * default is {@code false}.
     *
     * @property [allowMidiSysexMessages] Controls whether the `RESOURCE_MIDI_SYSEX` permission requests should be
     * automatically granted or not. The resource will allow sysex messages to be sent to or received from MIDI
     * devices. Available on API level 21 and above.
     *
     * @property [hideDefaultVideoPoster] Controls whether the default video poster (a gray, pixelated play button)
     * should be hidden.
     *
     * @property [layerType] The Layer Type of the WebView. Default is [LayerType.HARDWARE]
     */
    @Immutable
    public data class AndroidWebSettings public constructor(
        public val allowFileAccess: Boolean = false,
        public val textZoom: Int = 100,
        public val useWideViewPort: Boolean = false,
        public val standardFontFamily: String = "sans-serif",
        public val defaultFontSize: Int = 16,
        public val loadsImagesAutomatically: Boolean = true,
        public val isAlgorithmicDarkeningAllowed: Boolean = false,
        public val safeBrowsingEnabled: Boolean = true,
        public val domStorageEnabled: Boolean = false,
        public val mediaPlaybackRequiresUserGesture: Boolean = true,
        public val allowProtectedMedia: Boolean = false,
        public val allowMidiSysexMessages: Boolean = false,
        public val hideDefaultVideoPoster: Boolean = false,
        public val layerType: Int = LayerType.HARDWARE,
    ) : PlatformWebSettings {

        public object LayerType {

            public const val NONE: Int = 0
            public const val SOFTWARE: Int = 1
            public const val HARDWARE: Int = 2
        }
    }

    /**
     * Desktop web settings.
     */
    @Immutable
    public data class DesktopWebSettings public constructor(
        public val offScreenRendering: Boolean = false,
        public val transparent: Boolean = true,
        public val disablePopupWindows: Boolean = false,
    ) : PlatformWebSettings

    /**
     * IOS web settings.
     *
     * @property [opaque] The ios default opaque display The default value is {@code false}. When Value is true will
     * turn off these two properties: @param backgroundColor,@param underPageBackgroundColor
     *
     * @property [backgroundColor] The background color of the WebView client. The default value is {@code null}. Will
     * use WebSettings backgroundColor when null.
     *
     * @property [underPageBackgroundColor] The background color shown when the WebView client scrolls past the bounds
     * of the active page. The default value is `null`. Will use WebSettings backgroundColor when null.
     *
     * @property [bounces] Whether the WebView bounces when scrolled past content bounds. The default value is `true`.
     *
     * @property [scrollEnabled] Whether horizontal and vertical scrolling is enabled. The default value is `true`.
     *
     * @property [showHorizontalScrollIndicator] Whether the horizontal scroll indicator is visible. The default value
     * is `true`.
     *
     * @property [showVerticalScrollIndicator] Whether the vertical scroll indicator is visible. The default value is
     * `true`.
     *
     * @property [mediaPlaybackRequiresUserGesture] Whether a user gesture is required to play media. The default is
     * `true`.
     */
    @Immutable
    public data class IOSWebSettings public constructor(
        public val opaque: Boolean = false,
        public val backgroundColor: Color? = null,
        public val underPageBackgroundColor: Color? = null,
        public val bounces: Boolean = true,
        public val scrollEnabled: Boolean = true,
        public val showHorizontalScrollIndicator: Boolean = true,
        public val showVerticalScrollIndicator: Boolean = true,
        public val mediaPlaybackRequiresUserGesture: Boolean = true,
    ) : PlatformWebSettings

    public companion object
}
