package com.sopt.bubble.feature.more.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.feature.more.MoreViewModel.Companion.TOP_BAR_RATIO
import com.sopt.bubble.ui.theme.Headline01

@Composable
fun MoreTopAppBar(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(TOP_BAR_RATIO)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.more_top_bar_title),
            style = Headline01
        )
        Image(
            painter = painterResource(id = R.drawable.ic_more_btn_setting),
            contentDescription = null
        )
    }
}