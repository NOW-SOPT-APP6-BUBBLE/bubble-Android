package com.sopt.bubble.feature.frienddetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.sopt.bubble.R
import com.sopt.bubble.data.dto.ArtistMemberDetail
import com.sopt.bubble.feature.frienddetail.component.FriendDetailBottomBar
import com.sopt.bubble.feature.frienddetail.component.FriendDetailTopBar
import com.sopt.bubble.feature.friends.detail.DetailState
import com.sopt.bubble.feature.friends.detail.FriendDetailViewModel
import com.sopt.bubble.ui.theme.Body01
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.GrayBackground
import com.sopt.bubble.ui.theme.Headline03
import com.sopt.bubble.util.extension.toast

@Composable
fun FriendDetailScreen(
    modifier: Modifier = Modifier,
    friendDetailViewModel: FriendDetailViewModel = viewModel(),
    onNavigate: NavHostController,
    artistMemberId: String,
) {
    val postState by friendDetailViewModel.postState.collectAsStateWithLifecycle()
    val deleteState by friendDetailViewModel.deleteState.collectAsStateWithLifecycle()

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val artistDetail by friendDetailViewModel.artistDetail.collectAsState()

    var isStarFilled by remember { mutableStateOf(!artistDetail.isSubscribed) }

    LaunchedEffect(true) {
        friendDetailViewModel.artistMemberInfo(artistMemberId = artistMemberId)
    }

    LaunchedEffect(friendDetailViewModel.uiState, lifecycleOwner) {
        friendDetailViewModel.uiState.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { uiState ->
                when (uiState) {
                    is DetailState.Success -> {
                        uiState.artistDetail
                        isStarFilled = artistDetail.isSubscribed
                    }

                    is DetailState.Loading -> {}

                    is DetailState.Failure -> {}
                }
            }
    }

    LaunchedEffect(postState) {
        if (postState is FriendDetailState.Success) {
            isStarFilled = true
        }
    }

    LaunchedEffect(deleteState) {
        if (deleteState is FriendDetailState.Success) {
            isStarFilled = false
        }
    }

    LaunchedEffect(friendDetailViewModel.sideEffect, lifecycleOwner) {
        friendDetailViewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is FriendDetailSideEffect.Toast -> context.toast(sideEffect.message)
                }
            }
    }

    FriendDetailSuccessScreen(
        modifier = modifier,
        isStarFilled = isStarFilled,
        onPostStarClick = {
            friendDetailViewModel.deleteStar(artistMemberId)
        },
        onDeleteStarClick = {
            friendDetailViewModel.postStar(artistMemberId)
        },
        onNavigate = onNavigate,
        artistDetail = artistDetail,
    )
}

@Composable
fun FriendDetailSuccessScreen(
    modifier: Modifier = Modifier,
    isStarFilled: Boolean,
    onPostStarClick: () -> Unit,
    onDeleteStarClick: () -> Unit,
    onNavigate: NavHostController,
    artistDetail: ArtistMemberDetail,
) {
    Scaffold(
        topBar = {
            FriendDetailTopBar(
                modifier = modifier,
                isStarFilled = isStarFilled,
                onPostStarClick = { onPostStarClick() },
                onNavigate = onNavigate,
                onDeleteStarClick = { onDeleteStarClick() }
            )
        },
        bottomBar = {
            FriendDetailBottomBar(modifier)
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(GrayBackground),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
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
            Row(
                modifier = Modifier
                    .border(
                        width = 0.5.dp,
                        color = Gray200,
                        shape = RoundedCornerShape(size = 100.dp)
                    )
                    .wrapContentSize()
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "${artistDetail.artistName}  · ${artistDetail.artistMemberName}",
                    style = Body03,
                    color = Color.White
                )
            }
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
