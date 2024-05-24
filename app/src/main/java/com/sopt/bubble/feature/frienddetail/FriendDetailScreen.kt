package com.sopt.bubble.feature.frienddetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.feature.frienddetail.component.FriendDetailBottomBar
import com.sopt.bubble.feature.frienddetail.component.FriendDetailTopBar
import com.sopt.bubble.ui.theme.Body01
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Headline03

@Composable
fun FriendDetailScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            FriendDetailTopBar(modifier)
        },
        bottomBar = {
            FriendDetailBottomBar(modifier)
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Gray200)
        ) {
            Spacer(modifier = Modifier.weight(4f))
            Image(
                painter = painterResource(id = R.drawable.img_detail_profile),
                contentDescription = null,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .size(98.dp)
                    .clip(CircleShape)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_detail_artist),
                    contentDescription = null
                )
                Spacer(modifier = modifier.padding(5.dp))
                Text(
                    text = stringResource(id = R.string.detail_name),
                    color = Color.White,
                    style = Headline03
                )
            }
            Spacer(modifier = modifier.padding(4.dp))
            Text(
                text = stringResource(id = R.string.detail_sub_name),
                style = Body01,
                modifier = modifier.align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Spacer(modifier = modifier.weight(1f))
            Image(
                modifier = modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_detail_music),
                contentDescription = null
            )
            Spacer(modifier = modifier.weight(2f))
        }
    }
}