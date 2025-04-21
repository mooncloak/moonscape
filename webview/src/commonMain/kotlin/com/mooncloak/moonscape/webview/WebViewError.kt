package com.mooncloak.moonscape.webview

import androidx.compose.runtime.Immutable

/**
 * A wrapper class to hold errors from the WebView.
 *
 * @property [code] The request the error came from.
 *
 * @property [description] The error that was reported.
 *
 * @property [isFromMainFrame] Is the error related to a request from the main frame?
 *
 * @property [cause] The [Throwable] cause for this error.
 */
@Immutable
public data class WebViewError public constructor(
    public val code: Int? = null,
    public val description: String? = null,
    public val isFromMainFrame: Boolean = false,
    public val cause: Throwable? = null
)
