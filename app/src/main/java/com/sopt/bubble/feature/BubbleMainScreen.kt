package com.sopt.bubble.feature

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sopt.bubble.feature.nav.BubbleAppNavHost
import com.sopt.bubble.feature.nav.BubbleBottomNavigation
import com.sopt.bubble.feature.nav.Screen

@Composable
fun BubbleMainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BubbleBottomNavigation(navController) }
    ) { innerPadding ->
        BubbleAppNavHost(
            navController = navController,
            startDestination = Screen.Friends.route.toString(),
            modifier = Modifier.padding(innerPadding)
        )
    }
}