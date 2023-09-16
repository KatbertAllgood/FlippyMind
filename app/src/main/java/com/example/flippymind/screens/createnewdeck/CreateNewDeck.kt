package com.example.flippymind.screens.createnewdeck

import android.util.Log
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flippymind.R
import com.example.flippymind.ui.theme.FlippyMindSize
import com.example.flippymind.ui.theme.FlippyMindTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flippymind.model.DeckPresentation
import com.example.flippymind.utils.ColorConstants

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CreateNewDeckComposable(
    onClickBack: () -> Unit,
    viewModel: CreateNewDeckVM = viewModel()
) {
    FlippyMindTheme(
        textSize = FlippyMindSize.Medium
    ) {

        //region for focus

        val keyboardController = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current
        val interactionSource = remember { MutableInteractionSource() }

        //endregion

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FlippyMindTheme.colors.primaryBackground)
                .padding(
                    top = 20.dp
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    keyboardController?.hide()
                    focusManager.clearFocus(true)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
        ) {

            //region header

            Text(
                text = stringResource(id = R.string.create_new_deck),
                fontFamily = FlippyMindTheme.typography.heading.fontFamily,
                fontSize = FlippyMindTheme.typography.heading.fontSize,
                color = FlippyMindTheme.colors.primaryText
            )

            //endregion

            //region color chooser

            // placed here, because it's not possible to use composable in remember
            val deckPalette = FlippyMindTheme.deckColors

            val colors = listOf(
                Pair(ColorConstants.YELLOW, deckPalette.yellow),
                Pair(ColorConstants.GREEN, deckPalette.green),
                Pair(ColorConstants.RED, deckPalette.red),
                Pair(ColorConstants.BLUE, deckPalette.blue),
                Pair(ColorConstants.CIAN, deckPalette.cian),
                Pair(ColorConstants.PINK, deckPalette.pink),
            )

            val (selectedColor, onColorSelected) = remember {
                mutableStateOf(colors[0].second)
            }

            val selectedColorName = remember {
                mutableStateOf(colors[0].first)
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
                                selected = (color.second == selectedColor),
                                onClick = {
                                    onColorSelected(color.second)
                                    selectedColorName.value = color.first
                                          },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = color.second,
                                    unselectedColor = color.second
                                ),
                                modifier = modifier
                            )

                        }
                    }
                }
            }

            //endregion

            //region name input place

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
                            unfocusedLabelColor = FlippyMindTheme.colors.controlColor,
                            cursorColor = FlippyMindTheme.colors.controlColor
//                    focusedPlaceholderColor = FlippyMindTheme.colors.tertiaryBackground,
//                    unfocusedPlaceholderColor = FlippyMindTheme.colors.tertiaryBackground,
                        ),
                        label = {
                            Text(
                                text = stringResource(id = R.string.name_label),
                                fontFamily = FlippyMindTheme.typography.defaultBold.fontFamily,
                                fontSize = FlippyMindTheme.typography.defaultBold.fontSize
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

            //endregion

            //region confirm button

            val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

            Button(
                onClick = {
                    viewModel.insertDeck(
                        DeckPresentation(
                            id = null,
                            name = name.text,
                            cardsCount = 0,
                            color = selectedColorName.value
                        )
                    )

                    onBackPressedDispatcher?.onBackPressed()
                },
                shape = FlippyMindTheme.shape.cornersStyle,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(
                        top = 20.dp
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = FlippyMindTheme.colors.controlColor
                )
            ) {
                Text(
                    text = stringResource(id = R.string.confirm),
                    fontFamily = FlippyMindTheme.typography.defaultBold.fontFamily,
                    fontSize = FlippyMindTheme.typography.defaultBold.fontSize,
                    color = FlippyMindTheme.colors.primaryText
                )
            }

            //endregion

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