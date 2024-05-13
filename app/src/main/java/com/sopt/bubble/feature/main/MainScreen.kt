package com.sopt.bubble.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun MainScreen() {
    Column{

        Text(
            text = "Hello !",
            style = Headline01
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubbleAndroidTheme {
        MainScreen()
    }
}