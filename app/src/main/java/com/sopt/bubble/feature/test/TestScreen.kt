package com.sopt.bubble.feature.test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.sopt.bubble.feature.nav.BottomScreen

@Composable
fun TestScreen(
    onNavigate: NavHostController,
) {
    Column {
        Text(
            modifier = Modifier.clickable { onNavigate.navigate(BottomScreen.Friends.route) },
            text = "Test"
        )
    }
}