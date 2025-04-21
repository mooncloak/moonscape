package com.mooncloak.moonscape.text

import androidx.compose.ui.text.TextStyle

public actual fun TextStyle.withoutFontPadding(): TextStyle =
    this.copy()
