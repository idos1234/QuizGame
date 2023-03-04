package com.example.quizgame.ui

import com.example.quizgame.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.update

class QuizViewModel {
    private val _uiState = MutableStateFlow(UiState())

    fun setScore(Score: Int) {
        _uiState.update { currentState ->
            currentState.copy(score = Score)
        }
    }

}