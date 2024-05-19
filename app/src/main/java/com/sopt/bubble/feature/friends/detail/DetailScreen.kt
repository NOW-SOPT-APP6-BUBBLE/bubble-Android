package com.sopt.bubble.feature.friends.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.bubble.feature.friends.detail.component.DetailBottomBar
import com.sopt.bubble.feature.friends.detail.component.DetailTopBar
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Gray200

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            DetailTopBar(modifier)
        },
        bottomBar = {
            DetailBottomBar(modifier)
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Gray200)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubbleAndroidTheme {
        DetailScreen()
    }
}