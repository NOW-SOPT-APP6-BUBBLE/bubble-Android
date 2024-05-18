package com.sopt.bubble.feature.friends

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sopt.bubble.feature.nav.BubbleBottomNavigation
import com.sopt.bubble.feature.nav.Screen
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun FriendsScreen(
    onNavigate: NavHostController,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BubbleBottomNavigation(navHostController = onNavigate) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Friends",
                style = Headline01,
                modifier = Modifier.clickable { onNavigate.navigate(Screen.Test.route) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()

    BubbleAndroidTheme {
        FriendsScreen(navController)
    }
}