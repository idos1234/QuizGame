package com.example.quizgame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizgame.data.Questions
import com.example.quizgame.data.UiState
import com.example.quizgame.data.questions
import com.example.quizgame.ui.theme.Secondary
import com.example.quizgame.ui.theme.background
import com.example.quizgame.ui.theme.buttonColor
import java.util.Random

@Composable
fun GameScreen(AfterTenTimes: () -> Unit, viewModel: QuizViewModel = QuizViewModel(), onCorrectAnswer: () -> Unit) {
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
            Text(text = randomQuestion.question, color = Color.Black, fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))
        options.forEach { item ->
            Button(
                onClick = {
                    selectedValue = item
                    if (selectedValue == randomQuestion.correctAnswer) {
                         onCorrectAnswer()
                        countWords ++
                        if (countWords == 10) {
                            AfterTenTimes()
                        }
                        else{
                            randomQuestion = viewModel.makeRandomQuestion(randomQuestion)
                            answer1 = randomQuestion.answer1
                            answer2 = randomQuestion.answer2
                            answer3 = randomQuestion.answer3
                            answer4 = randomQuestion.answer4
                            options = listOf(answer1, answer2, answer3, answer4)

                        }
                    }
                    else{
                        countWords ++
                        if (countWords == 10) {
                            AfterTenTimes()
                        }
                        else{
                            randomQuestion = viewModel.makeRandomQuestion(randomQuestion)
                            answer1 = randomQuestion.answer1
                            answer2 = randomQuestion.answer2
                            answer3 = randomQuestion.answer3
                            answer4 = randomQuestion.answer4
                            options =listOf(answer1, answer2, answer3, answer4)
                        }
                    }
                    },
                colors = ButtonDefaults.buttonColors(buttonColor),
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
            ){
                Text(item)
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}