package com.example.quizgame.ui

import com.example.quizgame.data.Questions
import com.example.quizgame.data.UiState
import com.example.quizgame.data.questions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizViewModel {
    private val _uiState = MutableStateFlow(UiState())
    private var usedWords: List<Questions> = listOf()


    fun makeRandomQuestion(randomQuestion: Questions): Questions {
        usedWords += (randomQuestion)
        val question = questions.random()

        return if(usedWords.contains(question)) {
            var question = questions.random()
            (makeRandomQuestion(question))
        }
        else {
            question
        }
    }
}