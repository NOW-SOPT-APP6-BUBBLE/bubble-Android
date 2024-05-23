package com.sopt.bubble.feature.friends.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.feature.friends.FriendsViewModel.FriendsComponentConstants.COLLAPSED_TOP_BAR_HEIGHT
import com.sopt.bubble.feature.friends.FriendsViewModel.FriendsComponentConstants.EXPANDED_TOP_BAR_HEIGHT
import com.sopt.bubble.feature.more.MoreViewModel
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun FriendsTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(MoreViewModel.TOP_BAR_RATIO)
            .padding(horizontal = 20.dp)
            .height(EXPANDED_TOP_BAR_HEIGHT - COLLAPSED_TOP_BAR_HEIGHT),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.friends_top_bar_title),
            style = Headline01
        )
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_btn_search),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_btn_store),
                contentDescription = null
            )
        }
    }
}