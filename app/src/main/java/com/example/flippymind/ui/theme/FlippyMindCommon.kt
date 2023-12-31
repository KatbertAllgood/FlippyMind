package com.example.flippymind.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class FlippyMindColors(
    val primaryText: Color,
    val primaryBackground: Color,
//    val secondaryText: Color,
    val secondaryBackground: Color,
    val tertiaryBackground: Color,
    val controlColor: Color
)

data class FlippyMindDeckColors(
    val yellow: Color,
    val blue: Color,
    val green: Color,
    val cian: Color,
    val red: Color,
    val pink: Color,
)

data class FlippyMindTypography(
    val heading: TextStyle,
    val default: TextStyle,
    val defaultBold: TextStyle
)

data class FlippyMindShape(
    val padding: Dp,
    val cornersStyle: Shape
)

object FlippyMindTheme {
    internal val colors: FlippyMindColors
        @Composable
        internal get() = LocalFlippyMindColors.current

    internal val deckColors: FlippyMindDeckColors
        @Composable
        internal get() = LocalFlippyMindDeckColors.current

    internal val typography: FlippyMindTypography
        @Composable
        internal get() = LocalFlippyMindTypography.current

    internal val shape: FlippyMindShape
        @Composable
        internal get() = LocalFlippyMindShape.current
}

enum class FlippyMindSize {
    Small, Medium, Big
}

enum class FlippyMindCorners {
    Flat, Rounded
}


internal val LocalFlippyMindColors = staticCompositionLocalOf<FlippyMindColors>{
    error("No colors provided")
}

internal val LocalFlippyMindDeckColors = staticCompositionLocalOf<FlippyMindDeckColors> {
    error("No deck colors provided")
}

internal val LocalFlippyMindTypography = staticCompositionLocalOf<FlippyMindTypography> {
    error("No fonts provided")
}

internal val LocalFlippyMindShape = staticCompositionLocalOf<FlippyMindShape> {
    error("No shapes provided")
}