package com.example.flippymind

import android.inputmethodservice.Keyboard
import android.nfc.Tag
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flippymind.ui.theme.FlippyMindSize
import com.example.flippymind.ui.theme.FlippyMindTheme

class MainActivity : ComponentActivity() {

    private val TAG = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestPreview()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TestPreview(){
    FlippyMindTheme(
        textSize = FlippyMindSize.Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FlippyMindTheme.colors.primaryBackground)
        ) {
            DecksHeader()
        }
    }
}

@Composable
private fun DecksHeader() {

    FlippyMindTheme(

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    start = 12.dp,
                    end = 12.dp
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
                        .size(30.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "add new deck",
                    modifier = Modifier
                        .size(30.dp)
                )

            }
        }
    }
}