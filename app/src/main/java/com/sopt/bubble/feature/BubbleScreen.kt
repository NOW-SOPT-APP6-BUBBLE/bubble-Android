package com.sopt.bubble.feature

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sopt.bubble.feature.nav.BottomScreen
import com.sopt.bubble.feature.nav.BubbleAppNavHost
import com.sopt.bubble.feature.nav.BubbleBottomNavigation

@Composable
fun BubbleScreen() {
    val navController = rememberNavController()
    var isBottomBarVisible: Boolean
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    currentDestination?.route.let { route ->
        isBottomBarVisible = when (route) {
            BottomScreen.Friends.route -> true
            BottomScreen.Chat.route -> true
            BottomScreen.More.route -> true
            else -> false
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { if (isBottomBarVisible) BubbleBottomNavigation(navController) }
    ) { innerPadding ->
        BubbleAppNavHost(
            navController = navController,
            startDestination = BottomScreen.Friends.route,
            modifier = Modifier.padding(innerPadding)
        )
    }
}