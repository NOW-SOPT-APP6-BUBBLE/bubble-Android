package com.sopt.bubble.feature.precise_store.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray300
import com.sopt.bubble.ui.theme.Gray500
import com.sopt.bubble.ui.theme.Gray800
import com.sopt.bubble.ui.theme.Headline04
import com.sopt.bubble.ui.theme.White

@Composable
fun PreciseStoreArtistDescriptionView(
    artistName: String,
    bubbleDescription: String,
    serviceMember: String,
    nonServiceMember: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        /*아티스트 이름 텍스트*/
        Text(
            text = artistName.ifEmpty { "" },
            color = White,
            style = Headline04,
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(1.dp)
                .background(color = Gray800)
        )

        /*아티스트 버블 소개 텍스트*/
        Text(
            text = bubbleDescription,
            color = Gray300,
            style = Body03,
            modifier = Modifier.padding(top = 20.dp)
        )

        /*아티스트 라인업 텍스트*/
        Text(
            text = stringResource(id = R.string.precise_store_artist_lineup),
            color = White,
            style = Body02,
            modifier = Modifier.padding(top = 18.dp),
        )

        Text(
            text = serviceMember,
            color = White,
            style = Body03,
            modifier = Modifier.padding(top = 6.dp)
        )

        /*아티스트 커밍순 텍스트*/
        if (nonServiceMember.isNotBlank()) {
            Text(
                text = stringResource(id = R.string.precise_store_artist_coming_soon),
                color = Gray500,
                style = Body02,
                modifier = Modifier.padding(top = 18.dp)
            )
            Text(
                text = nonServiceMember,
                color = Gray500,
                style = Body03,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }
}