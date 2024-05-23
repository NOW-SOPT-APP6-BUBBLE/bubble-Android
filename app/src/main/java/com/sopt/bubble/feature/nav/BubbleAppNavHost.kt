package com.sopt.bubble.feature.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sopt.bubble.feature.chat.ChatScreen
import com.sopt.bubble.feature.friends.FriendsScreen
import com.sopt.bubble.feature.friends.detail.DetailScreen
import com.sopt.bubble.feature.friends.detail.DetailViewModel
import com.sopt.bubble.feature.more.MoreScreen
import com.sopt.bubble.feature.test.TestScreen

@Composable
fun BubbleAppNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(
            BottomScreen.Chat.route,
        ) {
            ChatScreen(
                onNavigate = navController
            )
        }

        composable(
            BottomScreen.Friends.route,
        ) {
            FriendsScreen(
                onNavigate = navController
            )
        }


        composable(
            BottomScreen.More.route,
        ) {
            MoreScreen(
                onNavigate = navController
            )
        }

        composable(
            Screen.Test.route
        ) {
            TestScreen(
                onNavigate = navController
            )
        }

        composable(
            Screen.Detail.route,
        ) {
            DetailScreen(
                onNavigate = navController,
                artistMemberId = 1,
                viewModel = DetailViewModel()
            )
        }
    }
}