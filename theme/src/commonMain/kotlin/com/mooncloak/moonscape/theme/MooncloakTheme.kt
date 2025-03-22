package com.mooncloak.moonscape.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

public interface MooncloakTheme {

    public val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme

    public val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography

    public val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.shapes

    public val spacings: Spacings
        @Composable
        @ReadOnlyComposable
        get() = LocalSpacings.current

    public val alphas: Alphas
        @Composable
        @ReadOnlyComposable
        get() = LocalAlphas.current

    public val preference: ThemePreference
        @Composable
        @ReadOnlyComposable
        get() = LocalThemePreference.current

    public companion object : MooncloakTheme
}

@Composable
public fun MooncloakTheme(
    themePreference: ThemePreference = LocalThemePreference.current,
    colorScheme: ColorScheme = if (themePreference.isInDarkTheme()) {
        mooncloakMoonlightColorScheme
    } else {
        mooncloakDaylightColorScheme
    },
    textSelectionColors: TextSelectionColors = TextSelectionColors(
        handleColor = colorScheme.primaryContainer,
        backgroundColor = colorScheme.onPrimaryContainer.copy(alpha = 0.4f),
    ),
    shapes: Shapes = MaterialTheme.shapes.copy(
        extraSmall = RoundedCornerShape(percent = 25)
    ),
    typography: Typography = MaterialTheme.typography,
    spacings: Spacings = LocalSpacings.current,
    alphas: Alphas = LocalAlphas.current,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography
    ) {
        CompositionLocalProvider(
            LocalTextSelectionColors provides textSelectionColors,
            LocalThemePreference provides themePreference,
            LocalSpacings provides spacings,
            LocalAlphas provides alphas
        ) {
            content()
        }
    }
}
