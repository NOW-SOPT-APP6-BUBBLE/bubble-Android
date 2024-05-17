package com.sopt.bubble.feature.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.sopt.bubble.feature.nav.BubbleBottomNavigation
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun MoreScreen(
    onNavigate: NavHostController,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BubbleBottomNavigation(navHostController = onNavigate) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "More",
                style = Headline01
            )
        }
    }
}