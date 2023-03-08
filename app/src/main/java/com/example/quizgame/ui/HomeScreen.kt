package com.example.quizgame.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.quizgame.ui.theme.Shapes
import com.example.quizgame.ui.theme.buttonColor

@Composable
fun HomeScreen(onClicked: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "App name",
            fontSize = 50.sp,
            modifier = Modifier.weight(3f)
        )
        Button(
            onClick = onClicked,
            colors = ButtonDefaults.buttonColors(buttonColor),
            shape = Shapes.large) {
            Text(
                text = "Start Quiz",
                fontSize = 50.sp
            )
        }
        Spacer(modifier = Modifier.weight(4f))
    }
}

@Composable
@Preview(showBackground = true)
fun HomePreview() {
    HomeScreen(onClicked = {})
}