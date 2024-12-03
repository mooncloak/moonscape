package com.mooncloak.moonscape.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

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
public actual fun rememberApplicationWindowManager(): ApplicationWindowManager = TODO()

@Composable
public actual fun ApplicationWindowContainer(
    manager: ApplicationWindowManager
) {

}
