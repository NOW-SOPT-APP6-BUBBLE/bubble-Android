package com.sopt.bubble.feature

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sopt.bubble.feature.nav.BottomScreen
import com.sopt.bubble.feature.nav.BubbleAppNavHost

@Composable
fun BubbleScreen(modifier: Modifier) {
    val navController = rememberNavController()

    BubbleAppNavHost(
        navController = navController,
        startDestination = BottomScreen.Friends.route,
        modifier = modifier
    )
}