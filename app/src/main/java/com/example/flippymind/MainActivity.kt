package com.example.flippymind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.domain.models.DeckModelDomain
import com.example.flippymind.screens.createnewdeck.CreateNewDeckComposable
import com.example.flippymind.screens.mainscreen.MainScreenComposable
import com.example.flippymind.ui.theme.FlippyMindSize
import com.example.flippymind.ui.theme.FlippyMindTheme
import com.example.flippymind.view.DeckItemComposable

class MainActivity : ComponentActivity() {

    private val TAG = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            FlippyMindTheme {

                NavHost(
                    navController = navController,
                    startDestination = MAIN_SCREEN
                ) {

                    composable(MAIN_SCREEN) {
                        MainScreenComposable {
                            navController.navigate(CREATE_NEW_DECK_SCREEN)
                        }
                    }

                    composable(CREATE_NEW_DECK_SCREEN) {
                        CreateNewDeckComposable {
                            navController.navigate(MAIN_SCREEN) {
                                popUpTo(MAIN_SCREEN) {
                                    inclusive = true
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    companion object {
        const val MAIN_SCREEN = "main_screen"
        const val CREATE_NEW_DECK_SCREEN = "create_new_deck_screen"
    }
}


