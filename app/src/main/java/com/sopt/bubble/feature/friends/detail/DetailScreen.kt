package com.sopt.bubble.feature.friends.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.sopt.bubble.R
import com.sopt.bubble.feature.friends.detail.component.DetailBottomBar
import com.sopt.bubble.feature.friends.detail.component.DetailTopBar
import com.sopt.bubble.ui.theme.Body01
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Headline03


@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    onNavigate: NavHostController,
    viewModel: DetailViewModel = viewModel(),
    artistMemberId: String,
) {
    val artistDetail by viewModel.artistDetail.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(true) {
        viewModel.artistMemberInfo(artistMemberId = artistMemberId)
    }

    LaunchedEffect(viewModel.uiState, lifecycleOwner) {
        viewModel.uiState.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { uiState ->
                when (uiState) {
                    is DetailState.Success -> {
                        uiState.artistDetail
                    }

                    is DetailState.Loading -> {}

                    is DetailState.Failure -> {}
                }
            }
    }

    Scaffold(
        topBar = {
            DetailTopBar(modifier, onNavigate = onNavigate)
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
            Spacer(modifier = Modifier.weight(4f))
            AsyncImage(
                model = artistDetail.imageURL,
                contentDescription = null,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .size(98.dp)
                    .clip(CircleShape)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_detail_artist),
                    contentDescription = null
                )
                Spacer(modifier = modifier.padding(5.dp))
                Text(
                    text = artistDetail.nickname,
                    color = Color.White,
                    style = Headline03
                )
            }
            Spacer(modifier = modifier.padding(4.dp))
            Text(
                text = artistDetail.introduction,
                style = Body01,
                modifier = modifier.align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Spacer(modifier = modifier.weight(1f))
            Image(
                modifier = modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_detail_music),
                contentDescription = null
            )
            Spacer(modifier = modifier.weight(2f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubbleAndroidTheme {
//        DetailScreen()
    }
}