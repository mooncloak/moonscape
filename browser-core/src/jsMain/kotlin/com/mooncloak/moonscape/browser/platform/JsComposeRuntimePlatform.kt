package com.mooncloak.moonscape.browser.platform

public actual val ComposeRuntimePlatform.Companion.current: ComposeRuntimePlatform
    get() = JsComposeRuntimePlatform

public actual sealed interface ComposeRuntimePlatform {

    public actual val name: String

    public actual val version: String?

    public actual val isJvmBased: Boolean

    public actual val isWebBased: Boolean

    public actual val isLinux: Boolean

    public actual val isMacos: Boolean

    public actual val isWindows: Boolean

    public actual companion object
}

internal data object JsComposeRuntimePlatform : ComposeRuntimePlatform {

    override val name: String = "WebJS"

    override val version: String? = null

    override val isJvmBased: Boolean = false

    override val isWebBased: Boolean = true

    override val isLinux: Boolean = false

    override val isMacos: Boolean = false

    override val isWindows: Boolean = false
}
