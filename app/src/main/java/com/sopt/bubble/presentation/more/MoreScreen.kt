package com.sopt.bubble.presentation.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Black
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray100
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Headline01
import com.sopt.bubble.ui.theme.Headline04
import com.sopt.bubble.ui.theme.White

@Composable
fun MoreScreen() {
    Scaffold(
        topBar = { MoreTopAppBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            MoreUserProfile(
                nickName = "언니",
                email = "612240@naver.com"
            )
            
            Spacer(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 37.dp, bottom = 12.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Gray100)
            )
        }
    }
}

@Composable
private fun MoreTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
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

@Composable
private fun MoreUserProfile(
    nickName: String,
    email: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_more_profile),
                contentDescription = null
            )

            Image(
                painter = painterResource(id = R.drawable.ic_more_profile_edit),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 100.dp, top = 100.dp)
                    .background(
                        shape = RoundedCornerShape(size = 30.dp),
                        color = White
                    )
            )
        }
        
        Text(
            text = nickName,
            style = Headline04,
            color = Black,
            modifier = Modifier.padding(top = 14.dp)
        )

        Text(
            text = email,
            style = Body03,
            color = Gray200,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoreScreenPreview() {
    MoreScreen()
}