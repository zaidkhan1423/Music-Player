package com.zaid.musicplayer.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Blue700,
    secondary = Teal200,
    onPrimary = Color.White,
    background = Color.Black
)

private val LightColorScheme = lightColorScheme(
    primary = Blue700,
    secondary = Teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,

)

@Composable
fun MusicPlayerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
       if(colorScheme == DarkColorScheme){
           SideEffect {
               val window = (view.context as Activity).window
               window.statusBarColor =  Color(0xFF000000).toArgb()
               WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
               WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = darkTheme
           }
       }else{
           SideEffect {
               val window = (view.context as Activity).window
               window.statusBarColor =  Color(0xFFFFFFFF).toArgb()
               WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
               WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = darkTheme
           }
       }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}