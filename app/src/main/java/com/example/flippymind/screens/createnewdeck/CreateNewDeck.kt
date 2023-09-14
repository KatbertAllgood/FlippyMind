package com.example.flippymind.screens.createnewdeck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flippymind.R
import com.example.flippymind.ui.theme.FlippyMindSize
import com.example.flippymind.ui.theme.FlippyMindTheme

@Composable
fun CreateNewDeckComposable(
    onClickBack: () -> Unit
) {
    FlippyMindTheme(
        textSize = FlippyMindSize.Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FlippyMindTheme.colors.primaryBackground)
                .padding(
                    top = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(id = R.string.create_new_deck),
                fontFamily = FlippyMindTheme.typography.heading.fontFamily,
                fontSize = FlippyMindTheme.typography.heading.fontSize,
                color = FlippyMindTheme.colors.primaryText
            )
            
            ColorChooser()

            NameInputPlace()

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

@Composable
private fun ColorChooser() {

    // placed here, because it's not possible to use composable in remember
    val deckPalette = FlippyMindTheme.deckColors

    val colors = listOf(
        deckPalette.yellow,
        deckPalette.green,
        deckPalette.red,
        deckPalette.blue,
        deckPalette.cian,
        deckPalette.pink,
    )

    val (selectedColor, onColorSelected) = remember {
        mutableStateOf(colors[0])
    }

    FlippyMindTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                ),
            colors = CardDefaults.cardColors(
                containerColor = FlippyMindTheme.colors.secondaryBackground
            ),
            shape = FlippyMindTheme.shape.cornersStyle,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {

            val modifier = Modifier
//                .background(
//                    color = FlippyMindTheme.colors.secondaryBackground,
//                    shape = CircleShape
//                )
                .scale(1.2f)

            Row(
                modifier = Modifier
                    .selectableGroup()
                    .fillMaxWidth()
                    .height(60.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                colors.forEach { color ->

                    RadioButton(
                        selected = (color == selectedColor),
                        onClick = { onColorSelected(color) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = color,
                            unselectedColor = color
                        ),
                        modifier = modifier
                    )

                }

//                RadioButton(
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    colors = RadioButtonDefaults.colors(
//                        selectedColor = FlippyMindTheme.deckColors.yellow,
//                        unselectedColor = FlippyMindTheme.deckColors.yellow
//                    ),
//                    modifier = modifier
//                )
//
//                RadioButton(
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    colors = RadioButtonDefaults.colors(
//                        selectedColor = FlippyMindTheme.deckColors.green,
//                        unselectedColor = FlippyMindTheme.deckColors.green
//                    ),
//                    modifier = modifier
//                )
//
//                RadioButton(
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    colors = RadioButtonDefaults.colors(
//                        selectedColor = FlippyMindTheme.deckColors.red,
//                        unselectedColor = FlippyMindTheme.deckColors.red
//                    ),
//                    modifier = modifier
//                )
//
//                RadioButton(
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    colors = RadioButtonDefaults.colors(
//                        selectedColor = FlippyMindTheme.deckColors.blue,
//                        unselectedColor = FlippyMindTheme.deckColors.blue
//                    ),
//                    modifier = modifier
//                )
//
//                RadioButton(
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    colors = RadioButtonDefaults.colors(
//                        selectedColor = FlippyMindTheme.deckColors.cian,
//                        unselectedColor = FlippyMindTheme.deckColors.cian
//                    ),
//                    modifier = modifier
//                )
//
//                RadioButton(
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    colors = RadioButtonDefaults.colors(
//                        selectedColor = FlippyMindTheme.deckColors.pink,
//                        unselectedColor = FlippyMindTheme.deckColors.pink
//                    ),
//                    modifier = modifier
//                )

            }
        }
    }
}

@Composable
private fun NameInputPlace() {

    var name by remember {
        mutableStateOf(
            TextFieldValue("")
        )
    }

    FlippyMindTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                ),
            colors = CardDefaults.cardColors(
                containerColor = FlippyMindTheme.colors.secondaryBackground
            ),
            shape = FlippyMindTheme.shape.cornersStyle,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                value = name,
                onValueChange = { newText ->
                    name = newText
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = FlippyMindTheme.colors.primaryText,
                    unfocusedTextColor = FlippyMindTheme.colors.primaryText,
                    focusedContainerColor = FlippyMindTheme.colors.secondaryBackground,
                    unfocusedContainerColor = FlippyMindTheme.colors.secondaryBackground,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = FlippyMindTheme.colors.controlColor,
                    unfocusedLabelColor = FlippyMindTheme.colors.primaryText,
                    cursorColor = FlippyMindTheme.colors.controlColor
//                    focusedPlaceholderColor = FlippyMindTheme.colors.tertiaryBackground,
//                    unfocusedPlaceholderColor = FlippyMindTheme.colors.tertiaryBackground,
                ),
                label = {
                    Text(
                        text = stringResource(id = R.string.name_label),
                        fontFamily = FlippyMindTheme.typography.default.fontFamily
                    )
                },
                shape = FlippyMindTheme.shape.cornersStyle,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.type_name_hint)
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FlippyMindTheme.typography.default.fontFamily
                )
            )
        }
    }
}