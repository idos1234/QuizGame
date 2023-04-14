package com.example.quizgame.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizgame.ui.theme.Shapes
import com.example.quizgame.ui.theme.buttonColor
import java.util.*
import kotlin.concurrent.schedule

@Composable
fun finalScore(score: Int, windowSize: WindowWidthSizeClass = WindowWidthSizeClass.Compact, onPlayAgain: () -> Unit = {}, nullifyScore: () -> Unit = {}, nullifyQuestions: () -> Unit = {}) {

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
        else -> {"Worst"}
    }

    val TitleSize: TextUnit = when (windowSize) {
        WindowWidthSizeClass.Compact -> 60.sp
        WindowWidthSizeClass.Medium -> 90.sp
        WindowWidthSizeClass.Expanded -> 90.sp
        else -> 90.sp
    }

    val textSize: TextUnit = when (windowSize) {
        WindowWidthSizeClass.Compact -> 64.sp
        WindowWidthSizeClass.Medium -> 100.sp
        WindowWidthSizeClass.Expanded -> 80.sp
        else -> 110.sp
    }

    val CardSize: Dp = when (windowSize) {
        WindowWidthSizeClass.Compact -> 300.dp
        WindowWidthSizeClass.Medium -> 350.dp
        WindowWidthSizeClass.Expanded -> 400.dp
        else -> 450.dp
    }

    val ButtonTextSize: TextUnit = when (windowSize) {
        WindowWidthSizeClass.Compact -> 18.sp
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

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Your score is:", fontSize = TitleSize, color = Color.Black)
            Spacer(modifier = Modifier.weight(2f))
            Card(shape = Shapes.large, backgroundColor = color, modifier = Modifier.size(CardSize)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "${score}/10", color = Color.Black, fontSize = textSize, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                    Text(text = text, color = Color.Black, fontSize = textSize, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.weight(2f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    onClick =
                    {
                        onPlayAgain()
                        Timer().schedule(100) {nullifyQuestions()}
                        Timer().schedule(500) {nullifyScore()}
                    },
                    colors = ButtonDefaults.buttonColors(buttonColor),
                    modifier = Modifier
                        .height(ButtonHeight)
                        .weight(1f))
                {
                    Text(text = "Play Again", fontSize = ButtonTextSize, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = {System.exit(0)},
                    colors = ButtonDefaults.buttonColors(buttonColor),
                    modifier = Modifier
                        .height(ButtonHeight)
                        .weight(1f))
                {
                    Text(text = "Quit App", fontSize = ButtonTextSize, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.weight(0.5f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview0() {
    finalScore(score = 0)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview1() {
    finalScore(score = 1)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview2() {
    finalScore(score = 2)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview3() {
    finalScore(score = 3)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview4() {
    finalScore(score = 4)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview5() {
    finalScore(score = 5)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview6() {
    finalScore(score = 6)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview7() {
    finalScore(score = 7)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview8() {
    finalScore(score = 8)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview9() {
    finalScore(score = 9)
}

@Preview(showBackground = true)
@Composable
fun Finalscorepreview10() {
    finalScore(score = 10)
}