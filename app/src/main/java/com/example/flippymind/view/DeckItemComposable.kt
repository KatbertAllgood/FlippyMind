package com.example.flippymind.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.models.DeckDomain
import com.example.flippymind.R
import com.example.flippymind.model.DeckPresentation
import com.example.flippymind.ui.theme.FlippyMindCorners
import com.example.flippymind.ui.theme.FlippyMindSize
import com.example.flippymind.ui.theme.FlippyMindTheme
import com.example.flippymind.utils.ColorConstants

@Preview(showBackground = true)
@Composable
private fun DeckPreview(){

    val deck: DeckPresentation = DeckPresentation(
        name = "Test name",
        cardsCount = 24,
        color = ColorConstants.GREEN
    )

    FlippyMindTheme {
        DeckItemComposable(deck)
    }
}

@Composable
fun DeckItemComposable(
    deckItem: DeckDomain
) {

    FlippyMindTheme(
        corners = FlippyMindCorners.Rounded,
        textSize = FlippyMindSize.Small
    ) {

        Card(
            elevation = CardDefaults
                .cardElevation(defaultElevation = 5.dp),
            shape = FlippyMindTheme.shape.cornersStyle,
            colors = CardDefaults.cardColors(
                containerColor = FlippyMindTheme.colors.secondaryBackground
            ),
            modifier = Modifier
//                .fillMaxWidth()
                .height(120.dp)
                .padding(10.dp)
                .aspectRatio(2f)
                .clickable {

                }
        ) {
            Column(
//                verticalArrangement = Arrangement.,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
//                    .background(FlippyMindTheme.colors.secondaryBackground)
                    .fillMaxSize()
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 10.dp,
                            vertical = 10.dp
                        )
//                        .background(Color.Red)
                ) {

                    val deckPalette = FlippyMindTheme.deckColors

                    Canvas(
                        modifier = Modifier
                            .size(
                                size = 20.dp
                            )
                    ) {
                        drawCircle(
                            color = when(deckItem.color) {
                                ColorConstants.YELLOW -> deckPalette.yellow
                                ColorConstants.GREEN -> deckPalette.green
                                ColorConstants.BLUE -> deckPalette.blue
                                ColorConstants.RED -> deckPalette.red
                                ColorConstants.CIAN -> deckPalette.cian
                                ColorConstants.PINK -> deckPalette.pink
                                else -> deckPalette.yellow
                            },
                        )
                    }

                    Text(
//                        text = when(deckItem.cardsCount % 100) {
//                            0 -> stringResource(
//                                 id = R.string.card_v3, deckItem.cardsCount)
//                            1 -> stringResource(
//                                id = R.string.card_v1, deckItem.cardsCount)
//                            in 2..4 -> stringResource(
//                                id = R.string.card_v2, deckItem.cardsCount)
//                            in 5..9 -> stringResource(
//                                id = R.string.card_v3, deckItem.cardsCount)
//                            else -> "error"
//                        },
                        text = stringResource(R.string.cards_in_deck, deckItem.cardsCount),
                        color = FlippyMindTheme.colors.primaryText,
                        fontFamily = FlippyMindTheme.typography.default.fontFamily,
                        fontSize = FlippyMindTheme.typography.default.fontSize
                    )
                }

                Text(
                    text = deckItem.name,
                    color = FlippyMindTheme.colors.primaryText,
                    fontFamily = FlippyMindTheme.typography.defaultBold.fontFamily,
//                    fontSize = FlippyMindTheme.typography.defaultBold.fontSize,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 10.dp,
                            end = 10.dp,
                            top = 8.dp,
                            bottom = 20.dp
                        )
                )
            }
        }
    }
}