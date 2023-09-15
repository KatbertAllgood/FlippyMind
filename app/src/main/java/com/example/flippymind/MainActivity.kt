package com.example.flippymind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flippymind.screens.createnewdeck.CreateNewDeckComposable
import com.example.flippymind.screens.mainscreen.MainScreenComposable
import com.example.flippymind.ui.theme.FlippyMindTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flippymind.screens.createnewdeck.CreateNewDeckVM
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
                    startDestination = MAIN_SCREEN,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {

                    composable(
                        route = MAIN_SCREEN
                    ) {

                        val viewModel = hiltViewModel<MainScreenVM>()
                        MainScreenComposable(
                            onClickNewDeck = {
                                navController.navigate(CREATE_NEW_DECK_SCREEN)
                            },
                            viewModel = viewModel
                        )
                    }

                    composable(
                        route = CREATE_NEW_DECK_SCREEN,
                        enterTransition = {
//                            fadeIn(
//                                animationSpec = tween(
//                                    300,
//                                    easing = LinearEasing
//                                )
//                            ) +
                            slideIntoContainer(
                                animationSpec = tween(
                                    400,
                                    easing = EaseIn
                                ),
                                towards = AnimatedContentTransitionScope.SlideDirection.Start
                            )
                        },
                        exitTransition = {
//                            fadeOut(
//                                animationSpec = tween(
//                                    300,
//                                    easing = LinearEasing
//                                )
//                            ) +
                            slideOutOfContainer(
                                animationSpec = tween(
                                    400,
                                    easing = EaseOut
                                ),
                                towards = AnimatedContentTransitionScope.SlideDirection.End
                            )
                        }
                    ) {

                        val viewModel = hiltViewModel<CreateNewDeckVM>()
                        CreateNewDeckComposable(
                            onClickBack = {
                                navController.navigate(MAIN_SCREEN) {
                                    popUpTo(MAIN_SCREEN) {
                                        inclusive = true
                                    }
                                }
                            },
                            viewModel = viewModel
                        )
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


