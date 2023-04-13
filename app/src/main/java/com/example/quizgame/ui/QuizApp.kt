package com.example.quizgame.ui

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.*


enum class ScreensNav() {
    Start(),
    Quiz(),
    Final()
}

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun QuizApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController(),
    viewModel: QuizViewModel = viewModel()
) {
    var score by remember {
        mutableStateOf(0)
    }

    var countQuestions by remember {
        mutableStateOf(0)
    }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = ScreensNav.valueOf(
        backStackEntry?.destination?.route ?: ScreensNav.Start.name
    )

    Scaffold(
        topBar = {
            QuizTopAppBar(
                currentScreen = currentScreen,
                countQuestions = countQuestions
            )
        }
    ) {

        NavHost(navController = navController, startDestination = ScreensNav.Start.name) {
            composable(route = ScreensNav.Start.name) {
                HomeScreen(
                    onClicked = {
                        navController.navigate(ScreensNav.Quiz.name)
                    },
                    windowSize = windowSize
                )
            }
            composable(route = ScreensNav.Quiz.name) {
                GameScreen(
                    viewModel = viewModel,
                    AfterTenTimes = {
                        navController.navigate(ScreensNav.Final.name)
                    },
                    onCorrectAnswer = { score += 1 },
                    afterQuestions = {countQuestions ++},
                    windowSize = windowSize
                )
            }
            composable(route = ScreensNav.Final.name) {
                finalScore(
                    score = score,
                    windowSize = windowSize,
                    onPlayAgain = {
                        navController.navigate((ScreensNav.Quiz.name))
                    },
                    nullifyScore = { score = 0 },
                    nullifyQuestions = {countQuestions = 0})
            }
        }
    }
}

@Composable
fun QuizTopAppBar(
    currentScreen: ScreensNav,
    modifier: Modifier = Modifier,
    countQuestions: Int
) {
    TopAppBar(
        title = {when(currentScreen) {
            ScreensNav.Start -> Text("Quiz Game", fontSize = 20.sp)
            ScreensNav.Quiz -> Text("Question: $countQuestions / 10", fontSize = 20.sp)
            ScreensNav.Final -> Text("Final Score", fontSize = 20.sp)
        } },
        modifier = modifier
    )
}
