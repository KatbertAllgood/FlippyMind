package com.example.flippymind.ui.theme

add//import android.app.Activity
//import android.os.Build
//import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.darkColorScheme
//import androidx.compose.material3.dynamicDarkColorScheme
//import androidx.compose.material3.dynamicLightColorScheme
//import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
//import androidx.compose.runtime.SideEffect
//import androidx.compose.ui.graphics.toArgb
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flippymind.R

//import androidx.core.view.WindowCompat

@Composable
internal fun FlippyMindTheme(
    textSize: FlippyMindSize = FlippyMindSize.Medium,
    paddingSize: FlippyMindSize = FlippyMindSize.Medium,
    corners: FlippyMindCorners = FlippyMindCorners.Rounded,
    content: @Composable () -> Unit
) {

    val colors = basePalette

    val typography = FlippyMindTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                FlippyMindSize.Small -> 18.sp
                FlippyMindSize.Medium -> 20.sp
                FlippyMindSize.Big -> 24.sp
            },
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.rubik_mono_one_regular))
        ),
        default = TextStyle(
            fontSize = when (textSize) {
                FlippyMindSize.Small -> 12.sp
                FlippyMindSize.Medium -> 14.sp
                FlippyMindSize.Big -> 16.sp
            },
            fontWeight = FontWeight.Normal
        )
    )

    val shapes = FlippyMindShape(
        padding = when (paddingSize) {
            FlippyMindSize.Small -> 12.dp
            FlippyMindSize.Medium -> 16.dp
            FlippyMindSize.Big -> 20.dp
        },
        cornersStyle = when (corners) {
            FlippyMindCorners.Flat -> RoundedCornerShape(0.dp)
            FlippyMindCorners.Rounded -> RoundedCornerShape(8.dp)
        }
    )

    CompositionLocalProvider(
        LocalFlippyMindColors provides colors,
        LocalFlippyMindTypography provides typography,
        LocalFlippyMindShape provides shapes,
        content = content
    )

}

//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)
//
//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
//)

//@Composable
//fun FlippyMindTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content
//    )
//}