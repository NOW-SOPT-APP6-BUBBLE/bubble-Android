package com.sopt.bubble.feature.friends.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
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
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.img_detail_profile),
                contentDescription = null,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .size(98.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.weight(1f))
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