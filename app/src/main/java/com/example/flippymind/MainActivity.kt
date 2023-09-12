package com.example.flippymind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flippymind.screens.createnewdeck.CreateNewDeckComposable
import com.example.flippymind.screens.mainscreen.MainScreenComposable
import com.example.flippymind.ui.theme.FlippyMindTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flippymind.screens.mainscreen.MainScreenVM

@AndroidEntryPoint
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

                        val viewModel = hiltViewModel<MainScreenVM>()
                        MainScreenComposable(viewModel)

//                        MainScreenComposable {
//                            navController.navigate(CREATE_NEW_DECK_SCREEN)
//                        }
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


