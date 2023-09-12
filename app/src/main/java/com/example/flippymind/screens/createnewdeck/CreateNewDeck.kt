package com.example.flippymind.screens.createnewdeck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flippymind.ui.theme.FlippyMindSize
import com.example.flippymind.ui.theme.FlippyMindTheme

@Composable
fun CreateNewDeckComposable(
    onClickBack: () -> Unit
) {
    FlippyMindTheme(
        textSize = FlippyMindSize.Big
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FlippyMindTheme.colors.primaryBackground),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "CREATE NEW DECK",
                fontFamily = FlippyMindTheme.typography.heading.fontFamily,
                fontSize = FlippyMindTheme.typography.heading.fontSize,
                color = FlippyMindTheme.colors.primaryText
            )

            Button(
                onClick = {

                    onClickBack()
                }
            ) {
                Text(
                    text = "GO BACK"
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun CreateNewDeckPreview() {
    CreateNewDeckComposable(
        onClickBack = { }
    )
}