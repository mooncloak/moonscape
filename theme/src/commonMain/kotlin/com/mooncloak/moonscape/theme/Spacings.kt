package com.mooncloak.moonscape.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

public val DefaultHorizontalPageSpacing: Dp = 12.dp

@Immutable
public data class Spacings public constructor(
    public val page: PaddingValues = PaddingValues(horizontal = 12.dp),
    public val xsmall: Dp = 4.dp,
    public val small: Dp = 8.dp,
    public val medium: Dp = 12.dp,
    public val large: Dp = 16.dp,
    public val xlarge: Dp = 32.dp
)

internal val LocalSpacings: ProvidableCompositionLocal<Spacings> = staticCompositionLocalOf { Spacings() }
