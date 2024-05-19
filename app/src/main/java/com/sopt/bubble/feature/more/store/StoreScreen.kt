package com.sopt.bubble.feature.more.store

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.bubble.feature.more.store.component.StoreTopBar
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun StoreScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { StoreTopBar(modifier) }
    ) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            Text(
                text = "More",
                style = Headline01
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubbleAndroidTheme {
        StoreScreen()
    }
}