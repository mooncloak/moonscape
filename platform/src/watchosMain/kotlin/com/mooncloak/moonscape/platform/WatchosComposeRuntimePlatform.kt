package com.mooncloak.moonscape.platform

public actual val ComposeRuntimePlatform.Companion.current: ComposeRuntimePlatform
    get() = WatchosComposeRuntimePlatform

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

internal data object WatchosComposeRuntimePlatform : ComposeRuntimePlatform {

    override val name: String = "watchOS"

    override val version: String? = null

    override val isJvmBased: Boolean = false

    override val isWebBased: Boolean = false

    override val isLinux: Boolean = false

    override val isMacos: Boolean = false

    override val isWindows: Boolean = false
}
