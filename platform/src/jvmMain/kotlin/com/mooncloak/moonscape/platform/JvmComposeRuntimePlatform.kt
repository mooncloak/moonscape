package com.mooncloak.moonscape.platform

public actual val ComposeRuntimePlatform.Companion.current: ComposeRuntimePlatform
    get() = JvmComposeRuntimePlatform

public actual sealed interface ComposeRuntimePlatform {

    public actual val name: String

    public actual val version: String?

    public actual val isJvmBased: Boolean

    public actual val isWebBased: Boolean

    public actual val isLinux: Boolean

    public actual val isMacos: Boolean

    public actual val isWindows: Boolean

    public val osName: String?

    public actual companion object
}

internal data object JvmComposeRuntimePlatform : ComposeRuntimePlatform {

    override val name: String = "JVM"

    override val version: String?
        get() = System.getProperty("java.version")

    override val isJvmBased: Boolean = true

    override val isWebBased: Boolean = false

    override val isLinux: Boolean
        get() = osName?.contains("linux") == true

    override val isMacos: Boolean
        get() = (osName?.contains("mac") == true) || (osName?.contains("darwin") == true)

    override val isWindows: Boolean
        get() = (osName?.contains("windows") == true) || (osName?.contains("mingw") == true)

    override val osName: String?
        get() = System.getProperty("os.name")
}
