package com.mooncloak.moonscape.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
public data class Alphas public constructor(
    public val primary: Float = 1f,
    public val secondary: Float = 0.68f,
    public val tertiary: Float = 0.36f,
    public val quaternary: Float = 0.24f
)

internal val LocalAlphas: ProvidableCompositionLocal<Alphas> = staticCompositionLocalOf { Alphas() }
