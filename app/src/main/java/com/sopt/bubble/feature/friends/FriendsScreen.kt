package com.sopt.bubble.feature.friends

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.feature.BubbleTopBar
import com.sopt.bubble.ui.theme.BubbleAndroidTheme

@Composable
fun FriendsScreen() {
    Column {
        BubbleTopBar(
            text = stringResource(id = R.string.friends_title),
            iconContent = {
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                        },
                    painter = painterResource(id = R.drawable.ic_btn_search),
                    contentDescription = stringResource(id = R.string.friends_search)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                        },
                    painter = painterResource(id = R.drawable.ic_btn_store),
                    contentDescription = stringResource(id = R.string.friends_store)
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubbleAndroidTheme {
        FriendsScreen()
    }
}