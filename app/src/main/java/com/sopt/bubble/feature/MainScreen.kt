package com.sopt.bubble.feature

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
fun MainScreen(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {

        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = Headline01
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubbleAndroidTheme {
        MainScreen("Android")
    }
}