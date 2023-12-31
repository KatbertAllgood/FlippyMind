package com.example.flippymind.screens.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flippymind.R
import com.example.flippymind.model.DeckPresentation
import com.example.flippymind.ui.theme.FlippyMindSize
import com.example.flippymind.ui.theme.FlippyMindTheme
import com.example.flippymind.view.DeckItemComposable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flippymind.model.mapper.ListDeckToPresentation


@Composable
fun MainScreenComposable(
    onClickNewDeck: () -> Unit,
    viewModel: MainScreenVM = viewModel()
){

    val deckList = viewModel.decksList.collectAsState(initial = emptyList())

    FlippyMindTheme(
        textSize = FlippyMindSize.Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FlippyMindTheme.colors.primaryBackground)
        ) {
            DecksHeader(
                onClickNewDeck
            )

            DecksList(ListDeckToPresentation(deckList.value).map())

            CardsHeader()

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    FlippyMindTheme(
        textSize = FlippyMindSize.Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FlippyMindTheme.colors.primaryBackground)
        ) {
            DecksHeader(
                onClickNewDeck = { }
            )

            CardsHeader()

        }
    }
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
                    onClick = {
                        onClickNewDeck()
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = FlippyMindTheme.colors.controlColor
                    ),
                    modifier = Modifier
                        .height(40.dp)
                        .width(60.dp),
                    contentPadding = PaddingValues(0.dp)
                ){
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
private fun DecksList(decks: List<DeckPresentation>){

    FlippyMindTheme(){

        LazyRow(
            contentPadding = PaddingValues(
                horizontal = 10.dp,
                vertical = 5.dp
            ),
//            modifier = Modifier
//                .height(intrinsicSize = IntrinsicSize.Max)
        ) {

            items(decks) {
                DeckItemComposable(deckItem = it)
            }
        }
    }
}

@Composable
private fun CardsHeader() {
    FlippyMindTheme {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start, //switch to space between later
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 5.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ) {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_cards),
                    contentDescription = "cards icon",
                    modifier = Modifier
                        .size(37.dp)
                )
                Text(
                    text = stringResource(id = R.string.cards),
                    color = FlippyMindTheme.colors.primaryText,
                    fontFamily = FlippyMindTheme.typography.heading.fontFamily,
                    fontSize = FlippyMindTheme.typography.heading.fontSize,
                    modifier = Modifier
                        .padding(
                            start = 10.dp
                        )
                )
            }
        }
    }
}