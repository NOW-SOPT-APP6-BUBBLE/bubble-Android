package com.sopt.bubble.feature.friends.detail

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bubble.R
import com.sopt.bubble.feature.friends.detail.component.DetailBottomBar
import com.sopt.bubble.feature.friends.detail.component.DetailTopBar
import com.sopt.bubble.ui.theme.Body01
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Headline03
import com.sopt.bubble.util.extension.toast
import kotlinx.coroutines.launch

@Composable
fun DetailRoute(
    modifier: Modifier = Modifier,
    friendDetailViewModel: FriendDetailViewModel = viewModel()
) {
//    val postState by friendDetailViewModel.postState.collectAsStateWithLifecycle()
//    val deleteState by friendDetailViewModel.deleteState.collectAsStateWithLifecycle()

    var isStarFilled by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val scope = rememberCoroutineScope()

//    when (postState) {
//        FriendDetailState.Empty -> {
//
//        }
////        FriendDetailState.Failure -> return
//        FriendDetailState.Success -> isStarFilled = true
//    }
//
//    when (deleteState) {
//        FriendDetailState.Empty -> {}
////        FriendDetailState.Failure -> return
//        FriendDetailState.Success -> isStarFilled = false
//    }

//    LaunchedEffect(friendDetailViewModel.sideEffect, lifecycleOwner) {
//        friendDetailViewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
//            .collect { sideEffect ->
//                when (sideEffect) {
//                    is FriendDetailSideEffect.Toast -> context.toast(sideEffect.message)
//                }
//            }
//    }

    LaunchedEffect(friendDetailViewModel.postState, lifecycleOwner) {
        friendDetailViewModel.postState.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { state ->
                when (state) {
                    FriendDetailState.Success -> {
                        isStarFilled = true
                        context.toast(R.string.artist_profile_post_star_success)
                    }

                    FriendDetailState.Failure -> context.toast(R.string.artist_profile_post_star_failure)
                    FriendDetailState.Empty -> return@collect
                }
            }
    }

    LaunchedEffect(friendDetailViewModel.deleteState, lifecycleOwner) {
        friendDetailViewModel.deleteState.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { state ->
                when (state) {
                    FriendDetailState.Success -> {
                        isStarFilled = false
                        context.toast(R.string.artist_profile_delete_star_success)
                    }

                    FriendDetailState.Failure -> context.toast(R.string.artist_profile_delete_star_failure)

                    FriendDetailState.Empty -> return@collect
                }
            }
    }

    DetailScreen(
        modifier = modifier,
        isStarFilled = isStarFilled,
        onPostStarClick = {
            scope.launch {
                friendDetailViewModel.postStar()
            }
        },
        onDeleteStarClick = {
            scope.launch {
                friendDetailViewModel.deleteStar()
            }
        }
    )
}

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    isStarFilled: Boolean,
    onPostStarClick: () -> Unit,
    onDeleteStarClick: () -> Unit
) {
    Scaffold(
        topBar = {
            DetailTopBar(
                modifier = modifier,
                isStarFilled = isStarFilled,
                onPostStarClick = { onPostStarClick() },
                onDeleteStarClick = { onDeleteStarClick() }
            )
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
            Image(
                painter = painterResource(id = R.drawable.img_detail_profile),
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
                    text = stringResource(id = R.string.detail_name),
                    color = Color.White,
                    style = Headline03
                )
            }
            Spacer(modifier = modifier.padding(4.dp))
            Text(
                text = stringResource(id = R.string.detail_sub_name),
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