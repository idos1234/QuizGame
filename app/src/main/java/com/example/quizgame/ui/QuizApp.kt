package com.example.quizgame.ui

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizgame.data.UiState

enum class ScreensNav() {
    Start(),
    Quiz(),
    Final()
}

@Composable
fun QuizApp(
    uiState: UiState = UiState(),
    navController: NavHostController = rememberNavController()
) {
    var score by remember {
        mutableStateOf(0)
    }

    NavHost(navController = navController, startDestination = ScreensNav.Quiz.name) {
        composable(route = ScreensNav.Quiz.name) {
            GameScreen(
                AfterTenTimes = {
                navController.navigate(ScreensNav.Final.name)
            },
                onCorrectAnswer = { score += 1 }
            )
        }
        composable(route = ScreensNav.Final.name) {
            finalScore(score = score )
        }
    }
}