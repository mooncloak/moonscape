package com.mooncloak.moonscape.text

import androidx.compose.ui.text.input.TextFieldValue

/**
 * Allows associating extra data with a [TextFieldValue], such as an [error] message.
 *
 * @property [value] The [TextFieldValue] associated with the UI component.
 *
 * @property [error] The error message associated with the UI component. This allows error messages for individual Text
 * Input UI components.
 */
public data class TextFieldStateModel public constructor(
    public val value: TextFieldValue = TextFieldValue(),
    public val error: String? = null
) {

    public constructor(
        text: String,
        error: String? = null
    ) : this(
        value = TextFieldValue(text = text),
        error = error
    )
}

/**
 * Determines if the associated [TextFieldStateModel.error] value is `null`. Returns `true` if the
 * [TextFieldStateModel.error] value is `null`, `false` otherwise.
 */
public val TextFieldStateModel.isValid: Boolean
    inline get() = this.error == null
