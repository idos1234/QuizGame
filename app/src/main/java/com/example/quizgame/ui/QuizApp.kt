package com.example.quizgame.ui

import android.annotation.SuppressLint
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class ScreensNav() {
    Start(),
    Quiz(),
    Final()
}

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun QuizApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController()
) {
    var score by remember {
        mutableStateOf(0)
    }

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
                AfterTenTimes = {
                navController.navigate(ScreensNav.Final.name)
            },
                onCorrectAnswer = { score += 1 },
                windowSize = windowSize
            )
        }
        composable(route = ScreensNav.Final.name) {
            finalScore(score = score, windowSize = windowSize)
        }
    }
}