package com.sopt.bubble.feature.friends.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.GrayBackground

@Composable
fun DetailTopBar(
    modifier: Modifier,
    onNavigate: NavHostController,
    onStarClick: () -> Unit = {},
) {
    val isStarFilled = remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(GrayBackground)
            .padding(vertical = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .padding(start = 20.dp)
                .clickable {
                    onNavigate.popBackStack()
                },
            painter = painterResource(id = R.drawable.ic_detail_close),
            contentDescription = null,
        )
        if (isStarFilled.value) {
            Image(
                modifier = modifier
                    .padding(end = 15.dp)
                    .clickable {
                        isStarFilled.value = !isStarFilled.value
                        onStarClick()
                    },
                painter = painterResource(id = R.drawable.ic_detail_star_full),
                contentDescription = null
            )
        } else {
            Image(
                modifier = modifier
                    .padding(end = 15.dp)
                    .clickable {
                        isStarFilled.value = !isStarFilled.value
                        onStarClick()
                    },
                painter = painterResource(id = R.drawable.ic_detail_start_empty),
                contentDescription = null
            )
        }
    }
}
