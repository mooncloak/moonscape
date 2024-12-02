package com.mooncloak.moonscape.window

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.painter.Painter

/**
 * Represents a state model for a Window's Title Bar.
 *
 * @property [title] The title for the Window. Note that this will not be displayed in the Window's
 * Title Bar if [content] is provided. However, some platforms may still use this value in some of
 * their window manager UIs. Defaults to `null`.
 *
 * @property [icon] The icon [Painter] for the Window. This is typically displayed next to the
 * [title] on platforms that support it. Note that this will not be displayed in the Window's Title
 * Bar if [content] is provided. However, some platforms may still use this value in some of their
 * window manager UIs. Defaults to `null`.
 *
 * @property [content] The [Composable] content to display in the Window's Title Bar next to the
 * Window's controls. Note that if this value is not `null`, then the [title] and [icon] will not
 * be displayed in the Window's Title Bar; only the [content] will be displayed. Defaults to
 * `null`.
 */
@Immutable
public data class WindowTitleBarStateModel public constructor(
    public val title: String? = null,
    public val icon: Painter? = null,
    public val content: (@Composable RowScope.() -> Unit)? = null
)
