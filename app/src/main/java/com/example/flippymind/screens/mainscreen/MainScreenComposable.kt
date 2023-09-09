package com.example.flippymind.screens.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.models.DeckModelDomain
import com.example.flippymind.R
import com.example.flippymind.ui.theme.FlippyMindSize
import com.example.flippymind.ui.theme.FlippyMindTheme
import com.example.flippymind.view.DeckItemComposable

@Composable
fun MainScreenComposable(
    onClickNewDeck: () -> Unit
){
    FlippyMindTheme(
        textSize = FlippyMindSize.Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FlippyMindTheme.colors.primaryBackground)
        ) {
            DecksHeader(onClickNewDeck)
            DecksList()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreenComposable(
        onClickNewDeck = { }
    )
}

@Composable
private fun DecksHeader(
    onClickNewDeck: () -> Unit
) {
    FlippyMindTheme() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_decks),
                    contentDescription = "decks icon"
                )

                Text(
                    text = stringResource(id = R.string.decks),
                    color = FlippyMindTheme.colors.primaryText,
                    fontFamily = FlippyMindTheme.typography.heading.fontFamily,
                    fontSize = FlippyMindTheme.typography.heading.fontSize,
                    modifier = Modifier
                        .padding(
                            start = 10.dp
                        )
                )

            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_four_dots_more),
                    contentDescription = "grid view of decks",
                    modifier = Modifier
                        .padding(
                            end = 20.dp
                        )
                        .size(20.dp)
                )

                Button(
                    modifier = Modifier
                        .size(20.dp),
                    onClick = {

                        onClickNewDeck()
                    }
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = "add new deck",
                        modifier = Modifier
                            .size(20.dp)
                    )

                }

            }
        }
    }
}

@Composable
private fun DecksList(){

    val list : List<DeckModelDomain> = listOf(
        DeckModelDomain(
            "новая папка",
            12,
            0xFF04963E
        ),
        DeckModelDomain(
            "Игарёха",
            227,
            0xFFEEAA00
        ),
        DeckModelDomain(
            "бебрская словарка",
            116,
            0xFF7289DA
        ),
        DeckModelDomain(
            "бебрская словарка",
            116,
            0xFF7289DA
        ),
        DeckModelDomain(
            "бебрская словаркаadskgjasdklgjasdkgjaskdjgadsl;jg;lkasdgj",
            116,
            0xFF7289DA
        ),
    )
    FlippyMindTheme(){


        LazyRow(
            contentPadding = PaddingValues(
                horizontal = 10.dp,
                vertical = 5.dp
            ),
//            modifier = Modifier
//                .height(intrinsicSize = IntrinsicSize.Max)
        ) {

            items(list) {
                DeckItemComposable(deckItem = it)
            }
        }
    }
}