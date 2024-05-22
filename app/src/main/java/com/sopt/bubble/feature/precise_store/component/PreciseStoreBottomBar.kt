package com.sopt.bubble.feature.precise_store.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Gray700
import com.sopt.bubble.ui.theme.Headline04
import com.sopt.bubble.ui.theme.JYPBLUE
import com.sopt.bubble.ui.theme.White
import com.sopt.bubble.util.extension.noRippleClickable

@Composable
fun PreciseStoreBottomBar(
    isChecked: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Gray700)
            .noRippleClickable { onClick() }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    shape = RoundedCornerShape(topEnd = 18.dp),
                    color = if (isChecked) JYPBLUE
                    else Gray200
                )
        ) {
            Text(
                text = stringResource(id = R.string.precise_store_bottom_bar_purchase),
                style = Headline04,
                color = White,
                modifier = Modifier.padding(vertical = 18.dp)
            )
        }
    }
}