package com.sopt.bubble.feature.precise_store.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Headline02
import com.sopt.bubble.util.extension.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreciseStoreTopBar(
    onClickBackIcon: () -> Unit,
    onClickCloseIcon: () -> Unit,
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, bottom = 20.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = stringResource(id = R.string.app_bar_content_description_back),
                        modifier = Modifier.noRippleClickable { onClickBackIcon() }

                    )
                    Text(
                        text = stringResource(id = R.string.precise_store_app_bar_header),
                        style = Headline02,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = stringResource(id = R.string.app_bar_content_description_close),
                    modifier = Modifier.noRippleClickable { onClickCloseIcon() }
                )
            }
        }
    )
}