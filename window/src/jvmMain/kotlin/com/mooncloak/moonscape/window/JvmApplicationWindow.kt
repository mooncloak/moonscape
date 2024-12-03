package com.mooncloak.moonscape.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Stable
public actual sealed interface ApplicationWindow {

    public actual val id: String?

    public actual val type: Any?

    public actual val style: ApplicationWindowStyle?

    public val state: WindowState

    public val onPreviewKeyEvent: (KeyEvent) -> Boolean

    public val onKeyEvent: (KeyEvent) -> Boolean

    public val content: @Composable FrameWindowScope.() -> Unit

    public suspend fun hide()

    public suspend fun show()

    public suspend fun toggleVisibility() {
        if (style?.visible == true) {
            hide()
        } else {
            show()
        }
    }

    public suspend fun toggleMinimized()

    public actual companion object
}

@Stable
public actual sealed interface ApplicationWindowManager {

    public actual val windows: List<ApplicationWindow>

    public operator fun get(id: String?): ApplicationWindow?

    @OptIn(ExperimentalUuidApi::class)
    public suspend fun open(
        id: String? = Uuid.random().toHexString(),
        type: Any? = null,
        style: ApplicationWindowStyle = ApplicationWindowStyle(),
        state: WindowState = WindowState(),
        onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
        onKeyEvent: (KeyEvent) -> Boolean = { false },
        content: @Composable FrameWindowScope.() -> Unit
    ): ApplicationWindow

    public suspend fun close(id: String?)

    public suspend fun closeAll()

    public actual companion object
}

@Composable
public actual fun rememberApplicationWindowManager(): ApplicationWindowManager =
    remember { ApplicationWindowManager() }

@Composable
public actual fun ApplicationWindowContainer(
    manager: ApplicationWindowManager
) {
    val coroutineScope = rememberCoroutineScope()

    manager.windows.forEach { window ->
        ApplicationWindowContent(
            window = window,
            onCloseRequest = {
                coroutineScope.launch {
                    manager.close(id = window.id)
                }
            },
            onMinimize = {
                coroutineScope.launch {
                    window.toggleMinimized()
                }
            },
            onToggleMaximize = {
                window.state.placement = if (window.state.placement == WindowPlacement.Floating) {
                    WindowPlacement.Maximized
                } else {
                    WindowPlacement.Floating
                }
            }
        )
    }
}

@Composable
internal fun ApplicationWindowContent(
    onCloseRequest: () -> Unit,
    onMinimize: () -> Unit,
    onToggleMaximize: () -> Unit,
    window: ApplicationWindow
) {
    val style = window.style ?: ApplicationWindowStyle()

    CompositionLocalProvider(LocalApplicationWindow provides window) {
        when (val decoration = style.decoration) {
            is ApplicationWindowDecoration.Custom -> {
                CustomDecorationWindow(
                    onCloseRequest = onCloseRequest,
                    onMinimize = onMinimize,
                    onToggleMaximize = onToggleMaximize,
                    title = decoration.title,
                    icon = decoration.icon,
                    state = window.state,
                    visible = style.visible,
                    transparent = style.transparent,
                    resizable = style.resizable,
                    enabled = style.enabled,
                    focusable = style.focusable,
                    alwaysOnTop = style.alwaysOnTop,
                    onPreviewKeyEvent = window.onPreviewKeyEvent,
                    onKeyEvent = window.onKeyEvent,
                    resizerThickness = decoration.resizerThickness,
                    titleBarContent = decoration.titleBar,
                    content = window.content
                )
            }

            is ApplicationWindowDecoration.Undecorated -> {
                Window(
                    onCloseRequest = onCloseRequest,
                    state = window.state,
                    visible = style.visible,
                    undecorated = true,
                    transparent = style.transparent,
                    resizable = style.resizable,
                    enabled = style.enabled,
                    focusable = style.focusable,
                    alwaysOnTop = style.alwaysOnTop,
                    onPreviewKeyEvent = window.onPreviewKeyEvent,
                    onKeyEvent = window.onKeyEvent,
                    content = window.content
                )
            }

            is ApplicationWindowDecoration.System -> {
                Window(
                    onCloseRequest = onCloseRequest,
                    state = window.state,
                    visible = style.visible,
                    title = decoration.title,
                    icon = decoration.icon,
                    undecorated = false,
                    transparent = style.transparent,
                    resizable = style.resizable,
                    enabled = style.enabled,
                    focusable = style.focusable,
                    alwaysOnTop = style.alwaysOnTop,
                    onPreviewKeyEvent = window.onPreviewKeyEvent,
                    onKeyEvent = window.onKeyEvent,
                    content = window.content
                )
            }

            else -> {
                Window(
                    onCloseRequest = onCloseRequest,
                    state = window.state,
                    visible = style.visible,
                    undecorated = false,
                    transparent = style.transparent,
                    resizable = style.resizable,
                    enabled = style.enabled,
                    focusable = style.focusable,
                    alwaysOnTop = style.alwaysOnTop,
                    onPreviewKeyEvent = window.onPreviewKeyEvent,
                    onKeyEvent = window.onKeyEvent,
                    content = window.content
                )
            }
        }
    }
}

internal operator fun ApplicationWindow.Companion.invoke(
    id: String?,
    type: Any?,
    style: ApplicationWindowStyle?,
    state: WindowState,
    onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    content: @Composable FrameWindowScope.() -> Unit
): ApplicationWindow = JvmApplicationWindow(
    id = id,
    type = type,
    initialStyle = style,
    state = state,
    onPreviewKeyEvent = onPreviewKeyEvent,
    onKeyEvent = onKeyEvent,
    content = content
)

@Stable
internal class JvmApplicationWindow internal constructor(
    override val id: String?,
    override val type: Any?,
    initialStyle: ApplicationWindowStyle?,
    override val state: WindowState,
    override val onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    override val onKeyEvent: (KeyEvent) -> Boolean = { false },
    override val content: @Composable FrameWindowScope.() -> Unit
) : ApplicationWindow {

    private val mutableStyle = mutableStateOf(initialStyle)

    override val style: ApplicationWindowStyle? by mutableStyle

    private val mutex = Mutex(locked = false)

    override suspend fun hide() {
        mutex.withLock {
            withContext(Dispatchers.Main) {
                mutableStyle.value = mutableStyle.value?.copy(visible = false)
                    ?: ApplicationWindowStyle(visible = false)
            }
        }
    }

    override suspend fun show() {
        mutex.withLock {
            withContext(Dispatchers.Main) {
                mutableStyle.value = mutableStyle.value?.copy(visible = true)
                    ?: ApplicationWindowStyle(visible = true)
            }
        }
    }

    override suspend fun toggleMinimized() {
        mutex.withLock {
            withContext(Dispatchers.Main) {
                state.isMinimized = !state.isMinimized
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is JvmApplicationWindow) return false

        if (id != other.id) return false
        if (type != other.type) return false
        if (state != other.state) return false
        if (onPreviewKeyEvent != other.onPreviewKeyEvent) return false
        if (onKeyEvent != other.onKeyEvent) return false
        if (content != other.content) return false
        if (style != other.style) return false
        if (mutex != other.mutex) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + state.hashCode()
        result = 31 * result + onPreviewKeyEvent.hashCode()
        result = 31 * result + onKeyEvent.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + (style?.hashCode() ?: 0)
        result = 31 * result + mutex.hashCode()
        return result
    }

    override fun toString(): String =
        "JvmApplicationWindow(content=$content, state=$state, type=$type, id=$id, style=$style, mutex=$mutex, onPreviewKeyEvent=$onPreviewKeyEvent, onKeyEvent=$onKeyEvent)"
}

internal operator fun ApplicationWindowManager.Companion.invoke(
    windows: List<ApplicationWindow> = emptyList()
): ApplicationWindowManager = JvmApplicationWindowManager(
    initialWindows = windows
)

@Stable
internal class JvmApplicationWindowManager internal constructor(
    initialWindows: List<ApplicationWindow> = emptyList()
) : ApplicationWindowManager {

    private val mutableWindows = mutableStateListOf<ApplicationWindow>().apply {
        addAll(initialWindows)
    }

    override val windows: List<ApplicationWindow> = mutableWindows

    private val mutex = Mutex(locked = false)

    override fun get(id: String?): ApplicationWindow? =
        mutableWindows.firstOrNull { window -> window.id == id }

    override suspend fun open(
        id: String?,
        type: Any?,
        style: ApplicationWindowStyle,
        state: WindowState,
        onPreviewKeyEvent: (KeyEvent) -> Boolean,
        onKeyEvent: (KeyEvent) -> Boolean,
        content: @Composable FrameWindowScope.() -> Unit
    ): ApplicationWindow {
        mutex.withLock {
            val index = windows.indexOfFirst { window -> window.id == id }
            val newWindow = ApplicationWindow(
                id = id,
                type = type,
                style = style,
                state = state,
                onPreviewKeyEvent = onPreviewKeyEvent,
                onKeyEvent = onKeyEvent,
                content = content
            )

            if (index == -1) {
                mutableWindows.add(newWindow)
            } else {
                mutableWindows.removeAt(index)
                mutableWindows.add(index, newWindow)
            }

            return newWindow
        }
    }

    override suspend fun close(id: String?) {
        mutex.withLock {
            mutableWindows.removeIf { window -> window.id == id }
        }
    }

    override suspend fun closeAll() {
        mutex.withLock {
            mutableWindows.clear()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is JvmApplicationWindowManager) return false

        if (windows != other.windows) return false
        if (mutex != other.mutex) return false

        return true
    }

    override fun hashCode(): Int {
        var result = windows.hashCode()
        result = 31 * result + mutex.hashCode()
        return result
    }

    override fun toString(): String = "JvmApplicationWindowManager(windows=$windows, mutex=$mutex)"
}
