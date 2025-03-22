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

package com.mooncloak.moonscape.browser.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.w3c.dom.Window
import org.w3c.dom.events.Event

@ExperimentalMaterial3WindowSizeClassApi
@Composable
public actual fun calculateWindowSizeClass(): WindowSizeClass {
    var windowSizeClass by remember {
        mutableStateOf(
            WindowSizeClass.calculateFromSize(window.getDpSize()),
        )
    }

    // Add a listener and listen for resize events
    DisposableEffect(Unit) {
        val callback: (Event) -> Unit = {
            windowSizeClass = WindowSizeClass.calculateFromSize(window.getDpSize())
        }

        window.addEventListener("resize", callback)

        onDispose {
            window.removeEventListener("resize", callback)
        }
    }

    return windowSizeClass
}

private fun Window.getDpSize(): DpSize = DpSize(innerWidth.dp, innerHeight.dp)
