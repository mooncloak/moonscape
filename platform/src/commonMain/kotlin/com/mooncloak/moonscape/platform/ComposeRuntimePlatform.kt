package com.mooncloak.moonscape.platform

/**
 * Retrieves the current [ComposeRuntimePlatform] that this application is currently running in.
 */
public expect val ComposeRuntimePlatform.Companion.current: ComposeRuntimePlatform

/**
 * Represents the target platform for the compose runtime. At runtime, this is the platform that is currently running
 * the application.
 */
public expect sealed interface ComposeRuntimePlatform {

    /**
     * The name of this platform.
     */
    public val name: String

    /**
     * The version of this platform.
     */
    public val version: String?

    public val isJvmBased: Boolean

    public val isWebBased: Boolean

    public val isLinux: Boolean

    public val isMacos: Boolean

    public val isWindows: Boolean

    public companion object
}
