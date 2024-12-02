package com.mooncloak.moonscape.platform

import platform.UIKit.UIDevice

public actual val ComposeRuntimePlatform.Companion.current: ComposeRuntimePlatform
    get() = IosComposeRuntimePlatform

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

internal data object IosComposeRuntimePlatform : ComposeRuntimePlatform {

    override val name: String = "iOS"

    override val version: String
        get() = UIDevice.currentDevice.systemVersion

    override val isJvmBased: Boolean = false

    override val isWebBased: Boolean = false

    override val isLinux: Boolean = false

    override val isMacos: Boolean = false

    override val isWindows: Boolean = false
}
