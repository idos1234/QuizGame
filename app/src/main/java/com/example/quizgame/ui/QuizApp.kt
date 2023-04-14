package com.example.quizgame.ui

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quizgame.ui.theme.buttonColor
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
                countQuestions = countQuestions,
                windowSize = windowSize
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
    windowSize: WindowWidthSizeClass,
    countQuestions: Int
) {

    val barHeight: Dp = when (windowSize) {
        WindowWidthSizeClass.Compact -> 56.dp
        WindowWidthSizeClass.Medium -> 70.dp
        WindowWidthSizeClass.Expanded -> 80.dp
        else -> 56.dp
    }

    TopAppBar(
        title = {when(currentScreen) {
            ScreensNav.Start -> Text("Quiz Game", fontSize = 40.sp)
            ScreensNav.Quiz -> Text("Question: ${countQuestions+1} / 10", fontSize = 35.sp)
            ScreensNav.Final -> Text("Final Score", fontSize = 40.sp)
        } },
        backgroundColor = com.example.quizgame.ui.theme.topAppBarColor,
        modifier = modifier.height(barHeight)
    )
}
