package com.mooncloak.moonscape.text

import androidx.compose.ui.text.TextStyle

/**
 * Creates a copy of this [TextStyle] instance but attempts to remove the font padding.
 *
 * > [!Note]
 * > When the system does not support removing font padding, then this function will simply return an exact copy of
 * > this [TextStyle] instance.
 */
public expect fun TextStyle.withoutFontPadding(): TextStyle
