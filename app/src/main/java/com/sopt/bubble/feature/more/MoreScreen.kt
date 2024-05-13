package com.sopt.bubble.feature.more

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun MoreScreen() {
    Column {
        Text(
            text = "More",
            style = Headline01
        )
    }
}