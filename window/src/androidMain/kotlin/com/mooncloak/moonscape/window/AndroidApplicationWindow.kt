package com.mooncloak.moonscape.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember

@Stable
public actual sealed interface ApplicationWindow {

    public actual val id: String?

    public actual val type: Any?

    public actual val style: ApplicationWindowStyle?

    public actual companion object
}

@Stable
public actual sealed interface ApplicationWindowManager {

    public actual val windows: List<ApplicationWindow>

    public actual companion object
}

@Composable
public actual fun rememberApplicationWindowManager(): ApplicationWindowManager =
    remember { ApplicationWindowManagerSingleton }

@Composable
public actual fun ApplicationWindowContainer(
    manager: ApplicationWindowManager
) {
    // No operation.
}

@Stable
internal data object ApplicationWindowSingleton : ApplicationWindow {

    override val id: String = "singleton"

    override val type: Any? = null

    override val style: ApplicationWindowStyle? = null
}

@Stable
internal data object ApplicationWindowManagerSingleton : ApplicationWindowManager {

    override val windows: List<ApplicationWindow> = listOf(ApplicationWindowSingleton)
}
