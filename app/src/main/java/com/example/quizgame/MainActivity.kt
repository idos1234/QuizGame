package com.example.quizgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.quizgame.ui.QuizApp
import com.example.quizgame.ui.theme.QuizGameTheme

@Suppress("", "OPT_IN_IS_NOT_ENABLED")
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizGameTheme() {
                val windowSizeClass = calculateWindowSizeClass(this)
                QuizApp(windowSize = windowSizeClass.widthSizeClass)
            }
        }
    }
}