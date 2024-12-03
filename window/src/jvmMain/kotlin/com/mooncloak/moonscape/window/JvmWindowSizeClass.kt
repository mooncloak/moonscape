/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * The following code is adapted from the (now-deprecated) material3-windowsizeclass-multiplatform library:
 * https://github.com/chrisbanes/material3-windowsizeclass-multiplatform
 *
 * The library has been deprecated because the components are going to be included in the compose multiplatform
 * framework, but there currently isn't a way to obtain an instance of the window size class in the common source set,
 * and the library doesn't support all our Kotlin targets. So, we are adding the implementation here. This project and
 * the material3-windowsizeclass-multiplatform are both under the Apache 2.0 license.
 *
 * Acknowledgement for work on material3-windowsizeclass-multiplatform library:
 * Copyright 2023, Christopher Banes and the project contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package com.mooncloak.moonscape.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.DpSize
import java.awt.Window
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent

@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalMaterial3WindowSizeClassApi
@Composable
public actual fun calculateWindowSizeClass(): WindowSizeClass {
    val density = LocalDensity.current
    val containerSize = LocalWindowInfo.current.containerSize

    val size = density.run { DpSize(containerSize.width.toDp(), containerSize.height.toDp()) }

    val window: Window? = getLocalWindow()

    var windowSizeClass by remember(window) {
        mutableStateOf(WindowSizeClass.calculateFromSize(size))
    }

    // Add a listener and listen for componentResized events
    DisposableEffect(window) {
        val listener = object : ComponentAdapter() {

            override fun componentResized(event: ComponentEvent) {
                windowSizeClass = WindowSizeClass.calculateFromSize(size)
            }
        }

        window?.addComponentListener(listener)

        onDispose {
            window?.removeComponentListener(listener)
        }
    }

    return windowSizeClass
}

/**
 * Retrieves the local [Window] value. The `androidx.compose.ui.window.LocalWindow` value is internal, so we can't
 * access it normally. So, we attempt to use reflection to obtain the value.
 *
 * FIXME: Hopefully they make this not internal, make a calculateWindowSizeClass function in the common source set
 * available, or consider depending on the (now deprecated) material3-windowsizeclass-multiplatform library, just in
 * this JVM source set, to obtain the window size class of that library and map to our instance.
 */
@Suppress("UNCHECKED_CAST")
@Composable
private fun getLocalWindow(): Window? {
    val localWindow = try {
        val localWindowClass = Class.forName("androidx.compose.ui.window.LocalWindow")
        val localWindowProperty = localWindowClass.getDeclaredField("LocalWindow").apply {
            this.isAccessible = true
        }

        localWindowProperty.get(null) as? CompositionLocal<Window>
    } catch (e: Exception) {
        null
    }

    return localWindow?.current
}
