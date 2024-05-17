package com.sopt.bubble.feature.friends.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Column(

    ) {
        Text(
            text = "Friends",
            style = Headline01
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubbleAndroidTheme {
        DetailScreen()
    }
}