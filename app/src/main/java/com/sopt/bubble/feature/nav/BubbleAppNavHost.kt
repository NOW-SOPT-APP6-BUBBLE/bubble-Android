package com.sopt.bubble.feature.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sopt.bubble.feature.chat.ChatScreen
import com.sopt.bubble.feature.friends.FriendsScreen
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
            BottomScreen.Friends.route,
        ) {
            FriendsScreen()
        }

        composable(
            BottomScreen.Chat.route,
        ) {
            ChatScreen(
                onNavigate = navController
            )
        }

        composable(
            BottomScreen.More.route,
        ) {
            MoreScreen()
        }

        composable(
            Screen.Test.route
        ) {
            TestScreen(
                onNavigate = navController
            )
        }
    }
}