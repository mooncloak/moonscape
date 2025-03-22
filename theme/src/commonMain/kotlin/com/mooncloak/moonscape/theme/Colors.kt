package com.mooncloak.moonscape.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

public data object MooncloakColorPalette {

    public val Gray_100: Color = Color(0xFFEBF1F5)
    public val Gray_200: Color = Color(0xFFD9E3EA)
    public val Gray_300: Color = Color(0xFFC5D2DC)
    public val Gray_400: Color = Color(0xFF9BA9B4)
    public val Gray_500: Color = Color(0xFF707D86)
    public val Gray_600: Color = Color(0xFF55595F)
    public val Gray_700: Color = Color(0xFF33363A)
    public val Gray_800: Color = Color(0xFF25282C)
    public val Gray_900: Color = Color(0xFF151719)

    public val Purple_100: Color = Color(0xFFF4F4FF)
    public val Purple_200: Color = Color(0xFFE2E1FF)
    public val Purple_300: Color = Color(0xFFCBCCFF)
    public val Purple_400: Color = Color(0xFFABABFF)
    public val Purple_500: Color = Color(0xFF8D8DFF)
    public val Purple_600: Color = Color(0xFF5D5DFF)
    public val Purple_700: Color = Color(0xFF4B4ACF)
    public val Purple_800: Color = Color(0xFF38379C)
    public val Purple_900: Color = Color(0xFF262668)

    public val Pink_500: Color = Color(red = 220, green = 40, blue = 120)
    public val Pink_600: Color = Color(red = 219, green = 39, blue = 119)

    public val Blue_500: Color = Color(red = 59, green = 130, blue = 246)
    public val Blue_600: Color = Color(red = 37, green = 99, blue = 235)

    public val Teal_500: Color = Color(red = 13, green = 149, blue = 137)
    public val Teal_600: Color = Color(red = 13, green = 148, blue = 136)

    public val MooncloakYellow: Color = Color(0xFFFCCA36)
    public val MooncloakYellowVariant: Color = Color(0xFFEBBD34)
    public val MooncloakYellowDark: Color = Color(0xFFD9AF30)

    public val MooncloakLightPrimary: Color = Color.White
    public val MooncloakLightPrimaryVariant: Color = Color(0xFFEDEDED)
    public val MooncloakLightPrimaryDark: Color = Color(0xFFDBDBDB)

    public val MooncloakDarkPrimary: Color = Color(0xFF1C2230)
    public val MooncloakDarkPrimaryBright: Color = Color(0xFF273043)
    public val MooncloakDarkPrimaryDark: Color = Color(0xFF12161F)

    public val MooncloakError: Color = Color(0xFFEB3D3D)
}

@Suppress("UnusedReceiverParameter")
@Composable
@ReadOnlyComposable
public fun ColorScheme.primaryVariant(isInDarkMode: Boolean = isSystemInDarkTheme()): Color =
    if (isInDarkMode) {
        MooncloakColorPalette.Purple_800
    } else {
        MooncloakColorPalette.Purple_200
    }

@Suppress("UnusedReceiverParameter")
@Composable
@ReadOnlyComposable
public fun ColorScheme.onPrimaryVariant(isInDarkMode: Boolean = isSystemInDarkTheme()): Color =
    if (isInDarkMode) {
        Color.White
    } else {
        MooncloakColorPalette.MooncloakDarkPrimaryDark
    }

internal val mooncloakDaylightColorScheme = lightColorScheme(
    background = MooncloakColorPalette.MooncloakLightPrimary,
    onBackground = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    surface = MooncloakColorPalette.MooncloakLightPrimaryVariant,
    surfaceContainer = MooncloakColorPalette.MooncloakLightPrimaryVariant,
    surfaceContainerLowest = MooncloakColorPalette.MooncloakLightPrimaryVariant,
    surfaceContainerLow = MooncloakColorPalette.MooncloakLightPrimaryVariant,
    surfaceContainerHigh = MooncloakColorPalette.MooncloakLightPrimaryDark,
    surfaceContainerHighest = MooncloakColorPalette.MooncloakLightPrimaryDark,
    surfaceVariant = MooncloakColorPalette.MooncloakLightPrimaryDark,
    surfaceDim = MooncloakColorPalette.MooncloakLightPrimaryDark,
    surfaceBright = MooncloakColorPalette.MooncloakLightPrimary,
    onSurface = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    onSurfaceVariant = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    error = MooncloakColorPalette.MooncloakError,
    errorContainer = MooncloakColorPalette.MooncloakError,
    onError = Color.White,
    onErrorContainer = Color.White,
    primary = MooncloakColorPalette.Purple_600,
    primaryContainer = MooncloakColorPalette.Purple_600,
    onPrimary = Color.White,
    onPrimaryContainer = Color.White,
    secondary = MooncloakColorPalette.MooncloakYellow,
    secondaryContainer = MooncloakColorPalette.MooncloakYellow,
    onSecondary = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    onSecondaryContainer = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    tertiary = MooncloakColorPalette.Teal_500,
    tertiaryContainer = MooncloakColorPalette.Teal_500,
    onTertiary = Color.White,
    onTertiaryContainer = Color.White
)

internal val mooncloakMoonlightColorScheme = darkColorScheme(
    background = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    onBackground = Color.White,
    surface = MooncloakColorPalette.MooncloakDarkPrimary,
    surfaceContainer = MooncloakColorPalette.MooncloakDarkPrimary,
    surfaceContainerLowest = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    surfaceContainerLow = MooncloakColorPalette.MooncloakDarkPrimary,
    surfaceContainerHigh = MooncloakColorPalette.MooncloakDarkPrimaryBright,
    surfaceContainerHighest = MooncloakColorPalette.MooncloakDarkPrimaryBright,
    surfaceVariant = MooncloakColorPalette.MooncloakDarkPrimaryBright,
    surfaceDim = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    surfaceBright = MooncloakColorPalette.MooncloakDarkPrimaryBright,
    onSurface = MooncloakColorPalette.MooncloakLightPrimaryVariant,
    onSurfaceVariant = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    error = MooncloakColorPalette.MooncloakError,
    errorContainer = MooncloakColorPalette.MooncloakError,
    onError = Color.White,
    onErrorContainer = Color.White,
    primary = MooncloakColorPalette.Purple_600,
    primaryContainer = MooncloakColorPalette.Purple_600,
    onPrimary = Color.White,
    onPrimaryContainer = Color.White,
    secondary = MooncloakColorPalette.MooncloakYellow,
    secondaryContainer = MooncloakColorPalette.MooncloakYellow,
    onSecondary = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    onSecondaryContainer = MooncloakColorPalette.MooncloakDarkPrimaryDark,
    tertiary = MooncloakColorPalette.Teal_500,
    tertiaryContainer = MooncloakColorPalette.Teal_500,
    onTertiary = Color.White,
    onTertiaryContainer = Color.White
)
