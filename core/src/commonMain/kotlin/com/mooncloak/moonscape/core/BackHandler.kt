package com.mooncloak.moonscape.core

import androidx.compose.runtime.Composable

/**
 * An effect for handling presses of the platform system back button. Implementations of this are platform specific and
 * performs no operations on platforms that don't support system back button actions.
 *
 * On Android, calling this in your composable adds the given lambda to the OnBackPressedDispatcher of the
 * LocalOnBackPressedDispatcherOwner.
 *
 * If this is called by nested composables, if enabled, the inner most composable will consume the call to system back
 * and invoke its lambda. The call will continue to propagate up until it finds an enabled BackHandler.
 *
 * > [!Note]
 * > This is a multiplatform variant of the [androidx.activity.compose.BackHandler] composable function. For platforms
 * > that don't support this operation (currently every platform except for Android), this function performs no
 * > operation. This is a convenience function for accessing back functionality in the common source set.
 *
 * ## Usage Example
 *
 * ```kotlin
 * var text by remember { mutableStateOf("") }
 *
 * TextField(value = text, onValueChange = { text = it })
 *
 * BackHandler(text. isNotEmpty()) {
 *     // handle back event
 * }
 * ```
 *
 * @param [enabled] if this BackHandler should be enabled
 *
 * @param [onBack] the action invoked by pressing the system back
 */
@Composable
public expect fun BackHandler(enabled: Boolean = true, onBack: () -> Unit)
