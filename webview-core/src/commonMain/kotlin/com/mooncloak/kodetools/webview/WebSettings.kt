package com.mooncloak.kodetools.webview

import androidx.compose.ui.graphics.Color

/**
 * Web settings for different platform.
 *
 * @property [isJavaScriptEnabled] Whether the WebView should enable JavaScript execution. Default is true.
 *
 * @property [customUserAgentString] WebView's user-agent string. Default is null.
 *
 * @property [zoomLevel] Set the zoom level of the WebView. Default is 1.0.
 *
 * @property [supportZoom] Whether the WebView should support zooming using its on-screen zoom controls and gestures.
 * The default is {@code true}.
 *
 * @property [allowFileAccessFromFileURLs] Whether cross-origin requests in the context of a file scheme URL should be
 * allowed to access content from other file scheme URLs. Note that some accesses such as image HTML elements don't
 * follow same-origin rules and aren't affected by this setting.
 * <p>
 * <b>Don't</b> enable this setting if you open files that may be created or altered by
 * external sources. Enabling this setting allows malicious scripts loaded in a {@code file://}
 * context to access arbitrary local files including WebView cookies and app private data.
 * <p class="note">
 * Loading content via {@code file://} URLs is generally discouraged. See the note in {@link #setAllowFileAccess}.
 * <p>
 * The default value is false.
 *
 * @property [allowUniversalAccessFromFileURLs] Whether cross-origin requests in the context of a file scheme URL
 * should be allowed to access content from <i>any</i> origin. This includes access to content from other file scheme
 * URLs or web contexts. Note that some access such as image HTML elements doesn't follow same-origin rules and isn't
 * affected by this setting.
 * <p>
 * <b>Don't</b> enable this setting if you open files that may be created or altered by
 * external sources. Enabling this setting allows malicious scripts loaded in a {@code file://}
 * context to launch cross-site scripting attacks, either accessing arbitrary local files
 * including WebView cookies, app private data or even credentials used on arbitrary web sites.
 * <p class="note">
 * Loading content via {@code file://} URLs is generally discouraged. See the note in
 * {@link #setAllowFileAccess}.
 * <p>
 * The default value is false.
 *
 * @property [backgroundColor] The background color of the WebView client. The default value is
 * {@code Color.Transparent}. Not supported on Desktop platform.
 *
 * @property [androidWebSettings] Android platform specific settings.
 *
 * @property [desktopWebSettings] Desktop platform specific settings.
 *
 * @property [iOSWebSettings] iOS platform specific settings.
 */
public data class WebSettings public constructor(
    public val isJavaScriptEnabled: Boolean = true,
    public val customUserAgentString: String? = null,
    public val zoomLevel: Double = 1.0,
    public val supportZoom: Boolean = true,
    public val allowFileAccessFromFileURLs: Boolean = false,
    public val allowUniversalAccessFromFileURLs: Boolean = false,
    public val backgroundColor: Color = Color.Transparent,
    public val androidWebSettings: PlatformWebSettings.AndroidWebSettings = PlatformWebSettings.AndroidWebSettings(),
    public val desktopWebSettings: PlatformWebSettings.DesktopWebSettings = PlatformWebSettings.DesktopWebSettings(),
    public val iOSWebSettings: PlatformWebSettings.IOSWebSettings = PlatformWebSettings.IOSWebSettings()
)
