package com.example.quizgame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizgame.data.questions
import com.example.quizgame.ui.theme.Secondary
import com.example.quizgame.ui.theme.background
import com.example.quizgame.ui.theme.buttonColor

@Composable
fun GameScreen(viewModel: QuizViewModel = viewModel(), AfterTenTimes: () -> Unit, onCorrectAnswer: () -> Unit, windowSize: WindowWidthSizeClass) {
    val textSize: TextUnit = when (windowSize) {
        WindowWidthSizeClass.Compact -> 30.sp
        WindowWidthSizeClass.Medium -> 50.sp
        WindowWidthSizeClass.Expanded -> 70.sp
        else -> 70.sp
    }
    val ButtonTextSize: TextUnit = when (windowSize) {
        WindowWidthSizeClass.Compact -> 25.sp
        WindowWidthSizeClass.Medium -> 35.sp
        WindowWidthSizeClass.Expanded -> 50.sp
        else -> 50.sp
    }
    val ButtonHeight: Dp = when (windowSize) {
        WindowWidthSizeClass.Compact -> 50.dp
        WindowWidthSizeClass.Medium -> 70.dp
        WindowWidthSizeClass.Expanded -> 80.dp
        else -> 80.dp
    }

    var randomQuestion by remember {
        mutableStateOf(questions.random())
    }
    var answer1 by remember {
        mutableStateOf(randomQuestion.answer1)
    }
    var answer2 by remember {
        mutableStateOf(randomQuestion.answer2)
    }
    var answer3 by remember {
        mutableStateOf(randomQuestion.answer3)
    }
    var answer4 by remember {
        mutableStateOf(randomQuestion.answer4)
    }
    var countWords by remember {
        mutableStateOf(0)
    }
    var options by remember {
        mutableStateOf(listOf(answer1, answer2, answer3, answer4))
    }
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(16.dp)
        .background(background)
        .fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(elevation = 20.dp, backgroundColor = Secondary) {
            Text(text = randomQuestion.question, color = Color.Black, fontSize = textSize,  modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.height(30.dp))
        options.forEach { item ->
            Row() {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        selectedValue = item
                        if (selectedValue == randomQuestion.correctAnswer) {
                            onCorrectAnswer()
                            countWords++
                            if (countWords == 10) {
                                viewModel.usedWords = mutableListOf()
                                AfterTenTimes()
                            } else {
                                randomQuestion = viewModel.makeRandomQuestion(randomQuestion)
                                answer1 = randomQuestion.answer1
                                answer2 = randomQuestion.answer2
                                answer3 = randomQuestion.answer3
                                answer4 = randomQuestion.answer4
                                options = listOf(answer1, answer2, answer3, answer4)

                            }
                        } else {
                            countWords++
                            if (countWords == 10) {
                                viewModel.usedWords = mutableListOf()
                                AfterTenTimes()
                            } else {
                                randomQuestion = viewModel.makeRandomQuestion(randomQuestion)
                                answer1 = randomQuestion.answer1
                                answer2 = randomQuestion.answer2
                                answer3 = randomQuestion.answer3
                                answer4 = randomQuestion.answer4
                                options = listOf(answer1, answer2, answer3, answer4)

                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(buttonColor),
                    modifier = Modifier
                        .height(ButtonHeight)
                        .weight(6f)
                ) {
                    Text(item, fontSize = ButtonTextSize)
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(ButtonHeight/2))
        }
    }
}