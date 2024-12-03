package com.mooncloak.moonscape.window

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowDecoration
import androidx.compose.ui.window.WindowDecorationDefaults
import androidx.compose.ui.window.WindowScope
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import com.mooncloak.moonscape.platform.ComposeRuntimePlatform
import com.mooncloak.moonscape.platform.current

/**
 * Represents an "undecorated", mooncloak themed Window that allows for custom decorations for the
 * title bar.
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun CustomDecorationWindow(
    state: WindowState = rememberWindowState(),
    title: String,
    icon: Painter?,
    onCloseRequest: () -> Unit,
    onMinimize: () -> Unit,
    onToggleMaximize: () -> Unit,
    themePreference: ApplicationWindowThemePreference = ApplicationWindowThemePreference.System, // TODO: Will be used for the custom system controls.
    visible: Boolean = true,
    transparent: Boolean = false,
    resizable: Boolean = true,
    enabled: Boolean = true,
    focusable: Boolean = true,
    alwaysOnTop: Boolean = false,
    resizerThickness: Dp = WindowDecorationDefaults.ResizerThickness,
    onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    titleBarContent: (@Composable RowScope.() -> Unit)? = null,
    content: @Composable FrameWindowScope.() -> Unit
) {
    Window(
        onCloseRequest = onCloseRequest,
        state = state,
        visible = visible,
        title = title,
        icon = icon,
        decoration = WindowDecoration.Undecorated(resizerThickness = resizerThickness),
        transparent = transparent,
        resizable = resizable,
        enabled = enabled,
        focusable = focusable,
        alwaysOnTop = alwaysOnTop,
        onPreviewKeyEvent = onPreviewKeyEvent,
        onKeyEvent = onKeyEvent
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                val platform = WindowPlatform.current

                AppWindowTitleBar(
                    platform = platform,
                    onClose = onCloseRequest,
                    onMinimize = onMinimize,
                    onMaximize = onToggleMaximize,
                    content = titleBarContent ?: {
                        if (icon != null) {
                            Icon(
                                painter = icon,
                                contentDescription = null
                            )
                        }

                        if (title.isNotBlank()) {
                            Text(
                                modifier = Modifier.padding(start = if (icon == null) 0.dp else 8.dp),
                                text = title,
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                )

                content.invoke(this@Window)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun WindowScope.AppWindowTitleBar(
    platform: WindowPlatform,
    onClose: () -> Unit,
    onMinimize: () -> Unit,
    onMaximize: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceDim,
    content: @Composable RowScope.() -> Unit
) {
    val controls: @Composable RowScope.() -> Unit = {
        WindowControls(
            platform = platform,
            onClose = onClose,
            onMinimize = onMinimize,
            onMaximize = onMaximize
        )
    }

    WindowDraggableArea(modifier = modifier) {
        val localIndication = LocalIndication.current
        val interactionSource = if (localIndication is IndicationNodeFactory) {
            // We can fast path here as it will be created inside clickable lazily
            null
        } else {
            // We need an interaction source to pass between the indication modifier and clickable, so
            // by creating here we avoid another composed down the line
            remember { MutableInteractionSource() }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .background(backgroundColor)
                .combinedClickable(
                    onClick = {}, // fixme: interfering with dragging of the window.
                    onDoubleClick = {
                        onMaximize.invoke()
                    },
                    interactionSource = interactionSource,
                    indication = null
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (platform.position == WindowControlPosition.Start) {
                controls.invoke(this)
            }

            content.invoke(this)

            if (platform.position == WindowControlPosition.End) {
                controls.invoke(this)
            }
        }
    }
}

private enum class WindowControlPosition {

    Start,
    End
}

private enum class WindowPlatform(val position: WindowControlPosition) {

    Linux(position = WindowControlPosition.Start), // FIXME: This should typically be "End". Update when Linux is implemented.
    Windows(position = WindowControlPosition.End),
    MacOs(position = WindowControlPosition.Start);

    companion object {

        val Default: WindowPlatform = MacOs

        val current: WindowPlatform
            @Composable
            get() {
                val platform = ComposeRuntimePlatform.current

                return when {
                    platform.isMacos -> MacOs
                    platform.isWindows -> Windows
                    platform.isLinux -> Linux
                    else -> Default
                }
            }
    }
}

@Composable
private fun RowScope.WindowControls(
    platform: WindowPlatform,
    onClose: () -> Unit,
    onMinimize: () -> Unit,
    onMaximize: () -> Unit
) {
    when (platform) {
        WindowPlatform.Linux -> LinuxWindowControls(
            onClose = onClose,
            onMinimize = onMinimize,
            onMaximize = onMaximize
        )

        WindowPlatform.Windows -> WindowsWindowControls(
            onClose = onClose,
            onMinimize = onMinimize,
            onMaximize = onMaximize
        )

        WindowPlatform.MacOs -> MacWindowControls(
            onClose = onClose,
            onMinimize = onMinimize,
            onMaximize = onMaximize
        )
    }
}

@Composable
private fun RowScope.LinuxWindowControls(
    onClose: () -> Unit,
    onMinimize: () -> Unit,
    onMaximize: () -> Unit
) {
    // TODO: Handle Linux appropriately.
    // Linux is more difficult because there can be different desktop environments and window
    // managers, and they each can have their own customizations. We should check for the typical
    // components (like GTK), otherwise fallback to a default. Right now we will just use MacOS
    // look and feel.
    MacWindowControls(
        onClose = onClose,
        onMinimize = onMinimize,
        onMaximize = onMaximize
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun RowScope.WindowsWindowControls(
    onClose: () -> Unit,
    onMinimize: () -> Unit,
    onMaximize: () -> Unit
) {
    val isFocused = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.align(Alignment.CenterVertically)
            .wrapContentSize()
            .padding(16.dp)
            .onPointerEvent(PointerEventType.Enter) {
                isFocused.value = true
            }
            .onPointerEvent(PointerEventType.Exit) {
                isFocused.value = false
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // TODO: Handle inactive/disabled
        // TODO: Specific Windows action icons
        // TODO: Make sure this is consistent with the windows standard

        Box(
            modifier = Modifier.size(24.dp)
                .clip(RectangleShape)
                .background(WindowsColors.maximize)
                .padding(4.dp)
                .clickable { onMaximize.invoke() },
            contentAlignment = Alignment.Center
        ) {
            if (isFocused.value) {
                Icon(
                    imageVector = Icons.Default.Fullscreen,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        Box(
            modifier = Modifier.size(24.dp)
                .clip(RectangleShape)
                .background(WindowsColors.minimize)
                .padding(4.dp)
                .clickable { onMinimize.invoke() },
            contentAlignment = Alignment.Center
        ) {
            if (isFocused.value) {
                Icon(
                    imageVector = Icons.Default.Minimize,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        Box(
            modifier = Modifier.size(24.dp)
                .clip(RectangleShape)
                .background(WindowsColors.close)
                .padding(4.dp)
                .clickable { onClose.invoke() },
            contentAlignment = Alignment.Center
        ) {
            if (isFocused.value) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun RowScope.MacWindowControls(
    onClose: () -> Unit,
    onMinimize: () -> Unit,
    onMaximize: () -> Unit
) {
    val isFocused = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.align(Alignment.CenterVertically)
            .wrapContentSize()
            .padding(16.dp)
            .onPointerEvent(PointerEventType.Enter) {
                isFocused.value = true
            }
            .onPointerEvent(PointerEventType.Exit) {
                isFocused.value = false
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // TODO: Handle inactive/disabled
        // TODO: Specific MacOS action icons

        Box(
            modifier = Modifier.size(12.dp)
                .clip(CircleShape)
                .background(MacOsColors.close)
                .padding(1.dp)
                .clickable { onClose.invoke() },
            contentAlignment = Alignment.Center
        ) {
            if (isFocused.value) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier.size(12.dp)
                .clip(CircleShape)
                .background(MacOsColors.minimize)
                .padding(1.dp)
                .clickable { onMinimize.invoke() },
            contentAlignment = Alignment.Center
        ) {
            if (isFocused.value) {
                Icon(
                    imageVector = MacOsMinimize,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier.size(12.dp)
                .clip(CircleShape)
                .background(MacOsColors.maximize)
                .padding(1.dp)
                .clickable { onMaximize.invoke() },
            contentAlignment = Alignment.Center
        ) {
            if (isFocused.value) {
                Icon(
                    imageVector = Icons.Default.Fullscreen,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}

private object MacOsColors {

    val close: Color
        @Composable
        get() = Color(0xFFFF605C)

    val minimize: Color
        @Composable
        get() = Color(0xFFFFBD40)

    val maximize: Color
        @Composable
        get() = if (isSystemInDarkTheme()) Color(0xFF32D74B) else Color(0xFF28CD41)
}

private object WindowsColors {

    val close: Color
        @Composable
        get() = Color(0xFFDC143C)

    val minimize: Color
        @Composable
        get() = Color(0xFFFFD700)

    val maximize: Color
        @Composable
        get() = Color(0xFF008000)
}

private val MacOsMinimize: ImageVector =
    materialIcon(name = "Filled.Minimize") {
        materialPath {
            moveTo(6.0f, 12.0f)
            horizontalLineToRelative(12.0f)
            verticalLineToRelative(2.0f)
            horizontalLineTo(6.0f)
            close()
        }
    }
