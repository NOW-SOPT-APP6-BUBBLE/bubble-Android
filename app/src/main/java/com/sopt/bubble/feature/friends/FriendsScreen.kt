package com.sopt.bubble.feature.friends

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.sopt.bubble.R
import com.sopt.bubble.feature.friends.component.FriendProfile
import com.sopt.bubble.feature.friends.component.FriendsTopAppBar
import com.sopt.bubble.feature.friends.component.MyProfile
import com.sopt.bubble.feature.nav.BubbleBottomNavigation
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.Gray100
import com.sopt.bubble.ui.theme.Gray400

@Composable
fun FriendsScreen(
    onNavigate: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: FriendsViewModel = viewModel(),
) {
    val starFriendsState by viewModel.starFriendsState.collectAsState()
    val friendsArtistState by viewModel.friendsArtistState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { FriendsTopAppBar() },
        bottomBar = { BubbleBottomNavigation(navHostController = onNavigate) }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier.padding(paddingValues)
        ) {
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
                        text = "${stringResource(R.string.friends_my_star)} ${starFriendsState.size}",
                        style = Body02,
                        color = Gray400,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_precise_store_fold),
                        contentDescription = null
                    )
                }
            }

            items(starFriendsState) { starFriends ->
                FriendProfile(
                    profileImage = starFriends.profileImage,
                    name = starFriends.name,
                    description = starFriends.description
                )
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
                        text = "${stringResource(R.string.friends_my_recommend)} ${friendsArtistState.size}",
                        style = Body02,
                        color = Gray400,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_precise_store_fold),
                        contentDescription = null
                    )
                }
            }

            items(friendsArtistState) { friendsArtist ->
                FriendProfile(
                    profileImage = friendsArtist.profileImage,
                    name = friendsArtist.name,
                    description = friendsArtist.description
                )
            }
        }
    }
}
