package com.sopt.bubble.feature.more.store.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray100

@Composable
fun StoreBottomBar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = Gray100)
            .fillMaxSize()
    ) {
        Text(
            modifier = modifier.padding(bottom = 17.dp),
            text = stringResource(id = R.string.store_bottom_1),
            style = Body03
        )
        Text(
            modifier = modifier.padding(bottom = 17.dp),
            text = stringResource(id = R.string.store_bottom_2),
            style = Body03
        )
        Text(
            modifier = modifier.padding(bottom = 17.dp),
            text = stringResource(id = R.string.store_bottom_3),
            style = Body03
        )
        Text(
            modifier = modifier.padding(bottom = 17.dp),
            text = stringResource(id = R.string.store_bottom_4),
            style = Body03
        )
        Text(
            modifier = modifier.padding(bottom = 17.dp),
            text = stringResource(id = R.string.store_bottom_5),
            style = Body03
        )
    }
}