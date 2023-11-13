package com.linhtetko.dailyvita.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColors(
    primary = LightRed,
    secondary = BlackBlue,
    surface = GreenLight,
    background = GreenLight,
    onPrimary = White,
    onSurface = BlackBlue,
    onBackground = BlackBlue
)

private val LightColorScheme = lightColors(
    primary = LightRed,
    secondary = BlackBlue,
    surface = GreenLight,
    background = GreenLight,
    onPrimary = White,
    onSurface = BlackBlue,
    onBackground = BlackBlue
)

@Composable
fun DailyVItaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colors = colorScheme,
        typography = Typography,
        content = content
    )
}