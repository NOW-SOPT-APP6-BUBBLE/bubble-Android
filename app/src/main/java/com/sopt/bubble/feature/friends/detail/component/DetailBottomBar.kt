package com.sopt.bubble.feature.friends.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Headline04

@Composable
fun DetailBottomBar(modifier: Modifier) {
    Box(
        modifier = modifier
            .background(Gray200)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topEnd = 18.dp)
                )
                .padding(vertical = 17.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.detail_bottom_title),
                style = Headline04
            )
        }
    }
}
