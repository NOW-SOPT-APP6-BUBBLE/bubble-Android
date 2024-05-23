@file:Suppress("UNUSED_EXPRESSION")

package com.sopt.bubble.feature.friends

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.sopt.bubble.R
import com.sopt.bubble.feature.friends.component.FriendProfile
import com.sopt.bubble.feature.friends.component.FriendsSmallTopAppBar
import com.sopt.bubble.feature.friends.component.FriendsTopAppBar
import com.sopt.bubble.feature.friends.component.MyProfile
import com.sopt.bubble.feature.nav.BubbleBottomNavigation
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.Gray100
import com.sopt.bubble.ui.theme.Gray400
import com.sopt.bubble.util.extension.noRippleClickable
import com.sopt.bubble.util.extension.toast

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FriendsScreen(
    onNavigate: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: FriendsViewModel = viewModel(),
) {
    val subsArtistList by viewModel.subsArtistList.collectAsState()
    val notSubsArtistList by viewModel.notSubsArtistList.collectAsState()

    val listState = rememberLazyListState()
    val isCollapsed: Boolean by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }

    var isStarFold: Boolean by remember { mutableStateOf(false) }
    val foldStarImageDrawRes =
        if (isStarFold) R.drawable.ic_precise_store_fold
        else R.drawable.ic_precise_store_unfold

    var isRecommendFold: Boolean by remember { mutableStateOf(false) }
    val foldRecommendImageDrawRes =
        if (isRecommendFold) R.drawable.ic_precise_store_fold
        else R.drawable.ic_precise_store_unfold


    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(true) {
        viewModel.getFriends()
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is FriendSideEffect.Success -> {
                        subsArtistList
                        notSubsArtistList
                    }

                    FriendSideEffect.Failure -> context.toast(R.string.server_fail)
                }
            }
    }

    Scaffold(
        topBar = { FriendsSmallTopAppBar(isCollapsed) },
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BubbleBottomNavigation(navHostController = onNavigate) }
    ) { paddingValues ->
        CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
            LazyColumn(
                modifier = modifier.padding(paddingValues),
                state = listState
            ) {
                item { FriendsTopAppBar() }
                item {
                    Text(
                        text = stringResource(R.string.friends_my_profile),
                        style = Body02,
                        color = Gray400,
                        modifier = modifier.padding(all = 16.dp)
                    )
                    MyProfile(
                        profileImage = R.drawable.ic_more_profile,
                        name = "언니",
                        description = ""
                    )
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = Gray100,
                    )
                    Row(
                        modifier = Modifier
                            .padding(all = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${stringResource(R.string.friends_my_star)} ${notSubsArtistList.size}",
                            style = Body02,
                            color = Gray400,
                        )
                        Icon(
                            modifier = Modifier.noRippleClickable {
                                isStarFold = !isStarFold
                            },
                            painter = painterResource(id = foldStarImageDrawRes),
                            contentDescription = null
                        )
                    }
                }
                if (isStarFold) {
                    items(
                        items = notSubsArtistList,
                        key = { it.artistMemberId }
                    ) { artist ->
                        FriendProfile(
                            profileImage = artist.imageURL,
                            name = artist.name,
                            description = artist.introduction
                        )
                    }
                }
                item {
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = Gray100,
                    )
                    Row(
                        modifier = Modifier
                            .padding(all = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${stringResource(R.string.friends_my_recommend)} ${subsArtistList.size}",
                            style = Body02,
                            color = Gray400,
                        )
                        Icon(
                            modifier = Modifier.noRippleClickable {
                                isRecommendFold = !isRecommendFold
                            },
                            painter = painterResource(id = foldRecommendImageDrawRes),
                            contentDescription = null
                        )
                    }
                }
                if (isRecommendFold) {
                    items(
                        items = subsArtistList,
                        key = { it.artistMemberId }
                    ) { artist ->
                        FriendProfile(
                            profileImage = artist.imageURL,
                            name = artist.name,
                            description = artist.introduction
                        )
                    }
                }
            }
        }
    }
}
