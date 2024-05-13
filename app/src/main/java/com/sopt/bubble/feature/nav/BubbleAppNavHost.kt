package com.sopt.bubble.feature.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sopt.bubble.feature.chat.ChatScreen
import com.sopt.bubble.feature.friends.FriendsScreen
import com.sopt.bubble.feature.more.MoreScreen

@Composable
fun BubbleAppNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier,
) {
    NavHost(navController = navController, startDestination = startDestination, modifier) {
        composable(
            Screen.Friends.route,
        ) {
            FriendsScreen()
        }

        composable(
            Screen.Chat.route,
        ) {
            ChatScreen()
        }

        composable(
            Screen.More.route,
        ) {
            MoreScreen()
        }
    }
}