package com.sopt.bubble.feature.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sopt.bubble.feature.chat.ChatScreen
import com.sopt.bubble.feature.friends.detail.DetailScreen
import com.sopt.bubble.feature.more.MoreScreen

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
            Screen.Friends.route.toString(),
        ) {
            DetailScreen()
        }

        composable(
            Screen.Chat.route.toString(),
        ) {
            ChatScreen()
        }

        composable(
            Screen.More.route.toString(),
        ) {
            MoreScreen()
        }
    }
}