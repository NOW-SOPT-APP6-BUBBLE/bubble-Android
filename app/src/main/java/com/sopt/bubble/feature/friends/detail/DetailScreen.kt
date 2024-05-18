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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
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

@Composable
private fun DetailTopBar(modifier: Modifier) {
    Row(
        modifier = modifier
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

@Composable
fun DetailBottomBar(modifier: Modifier) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(vertical = 17.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = "bubble",
            modifier = Modifier.align(Alignment.CenterHorizontally),
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