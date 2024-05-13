package com.sopt.bubble.feature.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun ChatScreen() {
    Column {
        Text(
            text = "Chat",
            style = Headline01
        )
    }
}