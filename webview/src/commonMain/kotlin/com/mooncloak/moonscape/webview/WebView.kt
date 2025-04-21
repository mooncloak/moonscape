package com.mooncloak.moonscape.webview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kotlin.jvm.JvmName

@Composable
public fun WebView(
    modifier: Modifier = Modifier,
    state: WebViewState = rememberWebViewState(),
    navigator: WebViewNavigator = rememberWebViewNavigator(),
    captureBackPresses: Boolean = true
) {
    val factory = getUnsafeLocalWebViewComponentFactory<WebViewState, WebViewNavigator>()
    val contentProvider = remember(factory) { factory.createWebViewContentProvider() }

    contentProvider.Content(
        state = state,
        navigator = navigator,
        modifier = modifier,
        captureBackPresses = captureBackPresses
    )
}

@JvmName("WebViewGeneric")
@Composable
public inline fun <reified State : WebViewState, reified Navigator : WebViewNavigator> WebView(
    modifier: Modifier = Modifier,
    state: State,
    navigator: Navigator,
    captureBackPresses: Boolean = true
) {
    val factory = getUnsafeLocalWebViewComponentFactory<State, Navigator>()
    val contentProvider = remember(factory) { factory.createWebViewContentProvider() }

    contentProvider.Content(
        state = state,
        navigator = navigator,
        modifier = modifier,
        captureBackPresses = captureBackPresses
    )
}
