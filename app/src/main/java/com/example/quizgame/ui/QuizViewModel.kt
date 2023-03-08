package com.example.quizgame.ui

import com.example.quizgame.data.Questions
import com.example.quizgame.data.questions

class QuizViewModel {
    private var usedWords: MutableList<Questions> = mutableListOf()



    fun makeRandomQuestion(randomQuestion: Questions): Questions {
        usedWords.add(randomQuestion)
        val question = questions.random()

        return if(usedWords.contains(question)) {
            (makeRandomQuestion(randomQuestion))
        }
        else {
            question
        }
    }
}