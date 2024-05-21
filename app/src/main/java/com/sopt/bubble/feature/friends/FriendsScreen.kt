package com.sopt.bubble.feature.friends

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.sopt.bubble.R
import com.sopt.bubble.feature.friends.component.FriendProfile
import com.sopt.bubble.feature.friends.component.FriendsTopAppBar
import com.sopt.bubble.feature.friends.component.MyProfile
import com.sopt.bubble.feature.nav.BubbleBottomNavigation
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Gray100
import com.sopt.bubble.ui.theme.Gray400

@Composable
fun FriendsScreen(
    onNavigate: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: FriendsViewModel = viewModel(),
) {
    val friendsArtistState by viewModel.friendsArtistState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { FriendsTopAppBar() },
        bottomBar = { BubbleBottomNavigation(navHostController = onNavigate) }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {
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
            Text(
                text = stringResource(R.string.friends_my_star),
                style = Body02,
                color = Gray400,
                modifier = modifier.padding(all = 16.dp)
            )
            LazyColumn {
                items(friendsArtistState) { friendsArtist ->
                    FriendProfile(
                        profileImage = R.drawable.ic_more_profile,
                        name = "설유니",
                        description = "하이"
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubbleAndroidTheme {
//        FriendsScreen()
    }
}