package com.mooncloak.kodetools.webview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

public fun interface WebViewContentProvider<State : WebViewState, Navigator : WebViewNavigator> {

    @Composable
    public fun Content(
        state: State,
        navigator: Navigator,
        modifier: Modifier,
        captureBackPresses: Boolean
    )

    public companion object
}
