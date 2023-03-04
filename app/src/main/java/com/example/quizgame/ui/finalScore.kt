package com.example.quizgame.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizgame.ui.theme.Shapes

@Composable
fun finalScore(score: Int) {

    val color: Color = when(score) {
        1 -> com.example.quizgame.ui.theme.score_1
        2 -> com.example.quizgame.ui.theme.score_2
        3 -> com.example.quizgame.ui.theme.score_3
        4 -> com.example.quizgame.ui.theme.score_4
        5 -> com.example.quizgame.ui.theme.score_5
        6 -> com.example.quizgame.ui.theme.score_6
        7 -> com.example.quizgame.ui.theme.score_7
        8 -> com.example.quizgame.ui.theme.score_8
        9 -> com.example.quizgame.ui.theme.score_9
        10 -> com.example.quizgame.ui.theme.score_10
        else -> {com.example.quizgame.ui.theme.score_1}
    }

    val text: String = when(score) {
        1 -> "Worst"
        2 -> "Terrible!"
        3 -> "Very bad!"
        4 -> "bad"
        5 -> "enough"
        6 -> "Fine"
        7 -> "Good"
        8 -> "Very Good"
        9 -> "Great"
        10 -> "excellent!"
        else -> {""}
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Your score is:", fontSize = 60.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Card(shape = Shapes.large, backgroundColor = color, modifier = Modifier.size(200.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "${score}/10", color = Color.Black, fontSize = 50.sp)
                    Text(text = text, color = Color.Black, fontSize = 40.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview1() {
    finalScore(score = 1)
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview2() {
    finalScore(score = 2)
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview3() {
    finalScore(score = 3)
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview4() {
    finalScore(score = 4)
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview5() {
    finalScore(score = 5)
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview6() {
    finalScore(score = 6)
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview7() {
    finalScore(score = 7)
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview8() {
    finalScore(score = 8)
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview9() {
    finalScore(score = 9)
}

@Preview(showBackground = true)
@Composable
fun finalscorepreview10() {
    finalScore(score = 10)
}