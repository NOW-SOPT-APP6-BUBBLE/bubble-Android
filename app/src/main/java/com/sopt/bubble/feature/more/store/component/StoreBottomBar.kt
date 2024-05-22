package com.sopt.bubble.feature.more.store.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray100
import com.sopt.bubble.ui.theme.Gray200

@Composable
fun StoreBottomBar(
    modifier: Modifier = Modifier,
    onScrollToTop: () -> Unit
) {
    Column(
        modifier = modifier
            .background(color = Gray100)
            .fillMaxSize()
            .padding(top = 23.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier.padding(bottom = 17.dp),
            text = stringResource(id = R.string.store_bottom_1),
            style = Body03,
            color = Gray200
        )
        Text(
            modifier = modifier.padding(bottom = 17.dp),
            text = stringResource(id = R.string.store_bottom_2),
            style = Body03,
            color = Gray200
        )
        Text(
            modifier = modifier.padding(bottom = 17.dp),
            text = stringResource(id = R.string.store_bottom_3),
            style = Body03,
            color = Gray200
        )
        Text(
            modifier = modifier.padding(bottom = 17.dp),
            text = stringResource(id = R.string.store_bottom_4),
            style = Body03,
            color = Gray200
        )
        Text(
            modifier = modifier.padding(bottom = 20.dp),
            text = stringResource(id = R.string.store_bottom_5),
            style = Body03,
            color = Gray200
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_store_triangle),
                contentDescription = null
            )
            Spacer(modifier = modifier.padding(6.dp))
            Text(
                text = stringResource(id = R.string.store_bottom_to_top),
                style = Body02,
                color = Gray200,
                modifier = modifier.clickable { onScrollToTop() }
            )
        }
        Spacer(modifier = modifier.padding(bottom = 23.dp))
    }
}