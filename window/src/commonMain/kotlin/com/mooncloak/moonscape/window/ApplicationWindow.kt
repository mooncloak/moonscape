package com.mooncloak.moonscape.window

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a Window within an application. Each Kotlin target platform has a different concept of a Window with
 * different functionality. This [ApplicationWindow] interface represents the Window functionality needed for an
 * application, and each platform provides their own implementation.
 */
@Stable
public expect sealed interface ApplicationWindow {

    /**
     * A unique and opaque [String] identifier for this [ApplicationWindow].
     */
    public val id: String?

    /**
     * A value that is used to group [ApplicationWindow]s by a type.
     */
    public val type: ApplicationWindowType

    /**
     * The style details for this [ApplicationWindow], or `null` if it is not available. Note that some platforms may
     * not support window styling details.
     */
    public val style: ApplicationWindowStyle?

    public companion object
}

public val LocalApplicationWindow: ProvidableCompositionLocal<ApplicationWindow> =
    staticCompositionLocalOf { error("No ApplicationWindow was provided.") }

@Stable
public expect sealed interface ApplicationWindowManager {

    public val windows: List<ApplicationWindow>

    public companion object
}

@Composable
public expect fun rememberApplicationWindowManager(): ApplicationWindowManager

@Composable
public expect fun ApplicationWindowContainer(
    manager: ApplicationWindowManager = rememberApplicationWindowManager()
)

/**
 * Represents a category for an [ApplicationWindow].
 *
 * > [!Note]
 * > Implementations of this interface MUST adhere to the [Stable] annotation requirements.
 */
@Stable
public interface ApplicationWindowType {

    /**
     * The name for this [ApplicationWindowType]. This value could be useful for logging purposes.
     */
    public val name: String

    /**
     * Whether multiple [ApplicationWindow]s of this [ApplicationWindowType] can exist within a
     * [ApplicationWindowManager.windows] list at a time. When opening an [ApplicationWindow] via an
     * [ApplicationWindowManager], if this value is `true`, then the [ApplicationWindow] will be opened and added to
     * the [ApplicationWindowManager.windows] list, otherwise, if this value is `false`, then the newly opened
     * [ApplicationWindow] will replace any existing [ApplicationWindow] with the same type in the
     * [ApplicationWindowManager.windows] list.
     */
    public val multiple: Boolean

    public companion object
}

@Immutable
public data class DefaultApplicationWindowType public constructor(
    public override val multiple: Boolean = true
) : ApplicationWindowType {

    override val name: String = "default"
}

@Immutable
public sealed interface ApplicationWindowDecoration {

    @Immutable
    public data class System public constructor(
        public val title: String = "",
        public val icon: Painter? = null
    ) : ApplicationWindowDecoration

    @Immutable
    public data class Undecorated public constructor(
        public val resizerThickness: Dp
    ) : ApplicationWindowDecoration

    /**
     *
     *
     * @property [title] The title for the Window. Note that this will not be displayed in the Window's
     * Title Bar if [titleBar] is provided. However, some platforms may still use this value in some of
     * their window manager UIs. Defaults to `null`.
     *
     * @property [icon] The icon [Painter] for the Window. This is typically displayed next to the
     * [title] on platforms that support it. Note that this will not be displayed in the Window's Title
     * Bar if [titleBar] is provided. However, some platforms may still use this value in some of their
     * window manager UIs. Defaults to `null`.
     *
     * @property [titleBar] The [Composable] content to display in the Window's Title Bar next to the
     * Window's controls. Note that if this value is not `null`, then the [title] and [icon] will not
     * be displayed in the Window's Title Bar; only the [titleBar] will be displayed. Defaults to
     * `null`.
     */
    @Immutable
    public data class Custom public constructor(
        public val resizerThickness: Dp,
        public val title: String = "",
        public val icon: Painter? = null,
        public val controls: Boolean = true,
        public val titleBar: (@Composable RowScope.() -> Unit)
    ) : ApplicationWindowDecoration

    public companion object
}

@Immutable
@Serializable
public enum class ApplicationWindowThemePreference(
    public val serialName: String
) {

    @SerialName(value = "dark")
    Dark(serialName = "dark"),

    @SerialName(value = "light")
    Light(serialName = "light"),

    @SerialName(value = "system")
    System(serialName = "system");

    public companion object {

        public operator fun get(serialName: String): ApplicationWindowThemePreference? =
            entries.firstOrNull { preference ->
                preference.serialName.equals(
                    serialName,
                    ignoreCase = true
                )
            }
    }
}

@Composable
@ReadOnlyComposable
public inline fun ApplicationWindowThemePreference.isInDarkTheme(): Boolean =
    when (this) {
        ApplicationWindowThemePreference.Dark -> true
        ApplicationWindowThemePreference.Light -> false
        ApplicationWindowThemePreference.System -> androidx.compose.foundation.isSystemInDarkTheme()
    }

@Immutable
public data class ApplicationWindowStyle public constructor(
    public val decoration: ApplicationWindowDecoration = ApplicationWindowDecoration.System(),
    public val themePreference: ApplicationWindowThemePreference = ApplicationWindowThemePreference.System,
    public val visible: Boolean = true,
    public val transparent: Boolean = false,
    public val resizable: Boolean = true,
    public val enabled: Boolean = true,
    public val focusable: Boolean = true,
    public val alwaysOnTop: Boolean = false,
)
