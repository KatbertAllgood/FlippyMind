package com.example.flippymind.ui.theme

import androidx.compose.ui.graphics.Color



internal val basePalette = FlippyMindColors(
    primaryText = Color(0xFFFFFFFF),
    primaryBackground = Color(0xFF1E2124),
    secondaryBackground = Color(0xFF282B30),
    tertiaryBackground = Color(0xFF36393E),
    controlColor = Color(0xFF7289DA),
)

//  maybe like this
//val bluePalette = basePalette.copy(
//    controlColor = Color(0xFF4D88FF)
//)

internal val deckPalette = FlippyMindDeckColors(
    yellow = Color(0xFFEEAA00),
    blue = Color(0xFF0070AF),
    green = Color(0xFF04963E),
    cian = Color(0xFF04B19D),
    red = Color(0xFFB00000),
    pink = Color(0xFFBC0071)
)