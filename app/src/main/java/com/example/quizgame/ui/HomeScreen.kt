package com.example.quizgame.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.quizgame.ui.theme.Shapes
import com.example.quizgame.ui.theme.buttonColor

@Composable
fun HomeScreen(onClicked: () -> Unit = {}, windowSize: WindowWidthSizeClass = WindowWidthSizeClass.Compact) {

    val textSize: TextUnit = when (windowSize) {
        WindowWidthSizeClass.Compact -> 70.sp
        WindowWidthSizeClass.Medium -> 90.sp
        WindowWidthSizeClass.Expanded -> 110.sp
        else -> 70.sp
    }
    val ButtonTextSize: TextUnit = when (windowSize) {
        WindowWidthSizeClass.Compact -> 50.sp
        WindowWidthSizeClass.Medium -> 75.sp
        WindowWidthSizeClass.Expanded -> 95.sp
        else -> 70.sp
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(2f))
        Row(modifier = Modifier.weight(3f)) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "App name",
                fontSize = textSize,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Row() {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onClicked,
                colors = ButtonDefaults.buttonColors(buttonColor),
                shape = Shapes.large,
                modifier = Modifier.weight(6f)
            ) {
                Text(
                    text = "Start Quiz",
                    fontSize = ButtonTextSize
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.weight(6f))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}