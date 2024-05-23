package com.sopt.bubble.feature.precise_store.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray400
import com.sopt.bubble.ui.theme.Gray800
import com.sopt.bubble.util.extension.noRippleClickable

@Composable
fun PreciseStoreMoreButton(
    isMore: Boolean,
    onClick: () -> Unit
) {
    val isMoreStringRes =
        if (isMore) R.string.precise_store_button_more_close
        else R.string.precise_store_button_more

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .drawBehind {
                val strokeWidth = 1.dp.toPx() // Border 두께
                drawLine(
                    brush = SolidColor(Gray800),
                    strokeWidth = strokeWidth,
                    start = Offset(0f, strokeWidth / 2),
                    end = Offset(size.width, strokeWidth / 2)
                )
            }
            .noRippleClickable { onClick() }
    ) {
        Text(
            text = stringResource(id = isMoreStringRes),
            color = Gray400,
            style = Body03,
            modifier = Modifier.padding(vertical = 22.dp)
        )
    }
}