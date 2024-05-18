package com.sopt.bubble.feature.friends.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            DetailTopAppBar()
        },
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Gray200)
        ) {
            Text(
                text = "Detail",
                style = Headline01
            )
        }
    }
}

@Composable
private fun DetailTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Gray200)
            .padding(horizontal = 31.dp, vertical = 52.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_detail_close),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.ic_detail_empty_star),
            contentDescription = null
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