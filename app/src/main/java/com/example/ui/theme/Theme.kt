package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = NeonGreen,
    onPrimary = DeepBlueDark,
    primaryContainer = DeepBlueCard,
    onPrimaryContainer = TextWhite,
    secondary = NeonGreenVibrant,
    onSecondary = DeepBlueDark,
    secondaryContainer = DarkSurfaceVariant,
    onSecondaryContainer = TextWhite,
    tertiary = NeonGreen,
    background = DarkBackground,
    onBackground = TextWhite,
    surface = DarkSurface,
    onSurface = TextWhite,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextMuted,
    outline = NeonGreenDark
)

private val LightColorScheme = lightColorScheme(
    primary = DeepBlue,
    onPrimary = TextWhite,
    primaryContainer = LightSurfaceVariant,
    onPrimaryContainer = TextDarkPrimary,
    secondary = NeonGreenDark,
    onSecondary = TextWhite,
    secondaryContainer = NeonGreenGlow,
    onSecondaryContainer = DeepBlueDark,
    tertiary = DeepBlueLight,
    background = LightBackground,
    onBackground = TextDarkPrimary,
    surface = LightSurface,
    onSurface = TextDarkPrimary,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = TextDarkSecondary,
    outline = DeepBlueLight
)

@Composable
fun PowerZoneTheme(
    darkTheme: Boolean = true, // Default to high-energy dark theme for Power & Energy branding
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    PowerZoneTheme(darkTheme = darkTheme, content = content)
}

