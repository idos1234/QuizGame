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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizgame.data.questions
import com.example.quizgame.ui.theme.Secondary
import com.example.quizgame.ui.theme.background
import com.example.quizgame.ui.theme.buttonColor

@Composable
fun GameScreen(AfterTenTimes: () -> Unit, viewModel: QuizViewModel = QuizViewModel(), onCorrectAnswer: () -> Unit, windowSize: WindowWidthSizeClass) {
    val textSize: TextUnit = when (windowSize) {
        WindowWidthSizeClass.Compact -> 30.sp
        WindowWidthSizeClass.Medium -> 50.sp
        WindowWidthSizeClass.Expanded -> 70.sp
        else -> 70.sp
    }
    val ButtonTextSize: TextUnit = when (windowSize) {
        WindowWidthSizeClass.Compact -> 20.sp
        WindowWidthSizeClass.Medium -> 30.sp
        WindowWidthSizeClass.Expanded -> 95.sp
        else -> 70.sp
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
            Text(text = randomQuestion.question, color = Color.Black, fontSize = textSize)
        }
        Spacer(modifier = Modifier.height(30.dp))
        options.forEach { item ->
            Row(modifier = Modifier.weight(2f)) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        selectedValue = item
                        if (selectedValue == randomQuestion.correctAnswer) {
                            onCorrectAnswer()
                            countWords++
                            if (countWords == 10) {
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
                        .width(200.dp)
                        .height(50.dp)
                        .weight(6f)
                ) {
                    Text(item, fontSize = ButtonTextSize)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}