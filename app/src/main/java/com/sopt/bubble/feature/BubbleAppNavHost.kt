package com.sopt.bubble.feature

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sopt.bubble.feature.main.MainScreen

@Composable
fun BubbleAppNavHost() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable(
            "main",
        ) {
            MainScreen()
        }
    }
}