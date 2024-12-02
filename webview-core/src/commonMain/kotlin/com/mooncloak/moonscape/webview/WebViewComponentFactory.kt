package com.mooncloak.moonscape.webview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.staticCompositionLocalOf

public interface WebViewComponentFactory<State : WebViewState, Navigator : WebViewNavigator> {

    public fun createWebViewContentProvider(): WebViewContentProvider<State, Navigator>

    public fun createWebViewState(content: WebContent? = null): State

    public fun createWebViewStateSaver(): Saver<State, Any>?

    public fun createWebViewNavigator(): Navigator

    public companion object
}

public val LocalWebViewComponentFactory: ProvidableCompositionLocal<WebViewComponentFactory<*, *>> =
    staticCompositionLocalOf { error("No 'WebViewComponentFactory' provided.") }

@Suppress("UNCHECKED_CAST")
@Composable
@PublishedApi
internal inline fun <reified State : WebViewState, reified Navigator : WebViewNavigator> getUnsafeLocalWebViewComponentFactory(): WebViewComponentFactory<State, Navigator> =
    (LocalWebViewComponentFactory.current as? WebViewComponentFactory<State, Navigator>)
        ?: error("The provided 'WebViewComponentFactory' does not have the expected types. Make sure you provide and expect the same generic types. State: ${State::class.simpleName}; Navigator: ${Navigator::class.simpleName}.")
