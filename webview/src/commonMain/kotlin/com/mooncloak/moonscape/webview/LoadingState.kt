package com.mooncloak.moonscape.webview

import androidx.compose.runtime.Immutable

/**
 * Sealed class for constraining possible loading states.
 * See [Initializing], [Loading], and [Finished].
 */
@Immutable
public sealed interface LoadingState {

    /**
     * Describes a WebView that has not yet loaded for the first time.
     */
    @Immutable
    public data object Initializing : LoadingState

    /**
     * Describes a webview between `onPageStarted` and `onPageFinished` events, contains a
     * [progress] property which is updated by the webview.
     */
    @Immutable
    public data class Loading public constructor(
        public val progress: Float? = null
    ) : LoadingState

    /**
     * Describes a webview that has finished loading content.
     */
    @Immutable
    public data object Finished : LoadingState

    public companion object
}
