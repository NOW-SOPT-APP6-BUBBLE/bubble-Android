package com.sopt.bubble.feature.frienddetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.util.extension.noRippleClickable

@Composable
fun FriendDetailTopBar(
    modifier: Modifier,
    isStarFilled: Boolean,
    onPostStarClick: () -> Unit = {},
    onDeleteStarClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Gray200)
            .padding(vertical = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier.padding(start = 20.dp),
            painter = painterResource(id = R.drawable.ic_detail_close),
            contentDescription = null,
        )
        Image(
            modifier = modifier
                .padding(end = 15.dp)
                .noRippleClickable {
                    if (isStarFilled) {
                        onDeleteStarClick()
                    } else {
                        onPostStarClick()
                    }
                },
            painter = if (isStarFilled) {
                painterResource(id = R.drawable.ic_detail_star_full)
            } else {
                painterResource(id = R.drawable.ic_detail_start_empty)
            },
            contentDescription = null
        )
    }
}
