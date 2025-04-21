package com.mooncloak.moonscape.text

import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.TextFieldValue

/**
 * Allows associating extra data with a [TextFieldValue], such as a [supporting] message.
 *
 * Input [TextField]s utilize the [TextFieldValue] class to represent the current input, but more often than not, there
 * is additional state associated with a [TextFieldValue], such as error messages. Instead of having two separate
 * values in a state model represent the values for a single [TextField], combining the two (value + supporting) is
 * very beneficial.
 *
 * @property [value] The [TextFieldValue] associated with the UI component.
 *
 * @property [supporting] The supporting text message associated with the UI component. This allows supporting text
 * messages for individual Text Input UI components.
 *
 * @property [isError] Whether the [supporting] text represents an error message.
 */
public data class TextFieldStateModel public constructor(
    public val value: TextFieldValue = TextFieldValue(),
    public val supporting: String? = null,
    public val isError: Boolean = true
) {

    public constructor(
        text: String,
        supporting: String? = null,
        isError: Boolean
    ) : this(
        value = TextFieldValue(text = text),
        supporting = supporting,
        isError = isError
    )

    public constructor(
        text: String,
        error: String? = null
    ) : this(
        value = TextFieldValue(text = text),
        supporting = error,
        isError = true
    )
}

/**
 * Retrieves the [TextFieldStateModel.supporting] if the [TextFieldStateModel.isError] is `true`, otherwise `null`.
 */
public val TextFieldStateModel.error: String?
    inline get() = if (this.isError) supporting else null

/**
 * Determines if the associated [TextFieldStateModel.supporting] value is `null` or blank when in an error state.
 * Returns `true` if the [TextFieldStateModel.supporting] value is `null` or blank when [TextFieldStateModel.isError]
 * is `true`, `false` otherwise.
 */
public val TextFieldStateModel.isValid: Boolean
    inline get() = !this.isError || this.supporting.isNullOrBlank()
