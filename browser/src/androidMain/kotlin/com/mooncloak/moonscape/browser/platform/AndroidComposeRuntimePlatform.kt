package com.mooncloak.moonscape.browser.platform

import android.os.Build

public actual val ComposeRuntimePlatform.Companion.current: ComposeRuntimePlatform
    get() = AndroidComposeRuntimePlatform

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

internal data object AndroidComposeRuntimePlatform : ComposeRuntimePlatform {

    override val name: String = "Android"

    override val version: String?
        get() = Build.VERSION.RELEASE

    override val isJvmBased: Boolean = true

    override val isWebBased: Boolean = false

    override val isLinux: Boolean = false

    override val isMacos: Boolean = false

    override val isWindows: Boolean = false
}
