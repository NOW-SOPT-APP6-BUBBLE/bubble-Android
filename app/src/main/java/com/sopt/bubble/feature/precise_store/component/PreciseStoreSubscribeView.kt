package com.sopt.bubble.feature.precise_store.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.data.dto.response.ResponsePreciseArtistDto
import com.sopt.bubble.feature.precise_store.PreciseStoreViewModel
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray400
import com.sopt.bubble.ui.theme.Gray500
import com.sopt.bubble.ui.theme.Gray800
import com.sopt.bubble.ui.theme.Name02
import com.sopt.bubble.ui.theme.Name03
import com.sopt.bubble.ui.theme.White
import com.sopt.bubble.util.extension.noRippleClickable
import java.text.NumberFormat
import java.util.Locale

@Composable
fun PreciseMoreSubscribeView(
    subscribeList: List<ResponsePreciseArtistDto.Result.Artist.Subscribe>
) {
    var isMorePressed by remember { mutableStateOf(false) }
    val moreIndex =
        if (subscribeList.size < PreciseStoreViewModel.MORE_UNFOLD_ITEM_LIMIT || isMorePressed) subscribeList.size
        else PreciseStoreViewModel.MORE_UNFOLD_ITEM_LIMIT

    Column(
        modifier = Modifier
            .wrapContentSize()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
    ) {
        for (subscribe in subscribeList.subList(0, moreIndex)) {
            PreciseStoreSubscribe(
                title = subscribe.name,
                price = subscribe.price,
                originalPrice = subscribe.previousPrice,
                modifier = if (subscribeList.indexOf(subscribe) != 0) Modifier.padding(top = 14.dp)
                else Modifier.padding(top = 26.dp)
            )
        }
    }

    if (!isMorePressed && subscribeList.size > PreciseStoreViewModel.MORE_UNFOLD_ITEM_LIMIT) {
        PreciseStoreMoreButton(onClick = { isMorePressed = !isMorePressed })
    } else {
        Spacer(modifier = Modifier.height(26.dp))
    }
}

@Composable
fun PreciseStoreSubscribe(
    title: String,
    price: Int,
    modifier: Modifier = Modifier,
    originalPrice: Int? = null,
) {
    val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
    Card(
        shape = RoundedCornerShape(
            topStart = 10.dp, topEnd = 10.dp,
            bottomStart = 10.dp, bottomEnd = 10.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Gray800),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 22.5.dp, horizontal = 12.dp)
        ) {
            Text(
                text = title,
                color = White,
                style = Name03
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (originalPrice != null) {
                    Text(
                        text = formatter.format(originalPrice).toString(),
                        color = Gray500,
                        style = Body03,
                    )
                }
                Text(
                    text = stringResource(id = R.string.precise_store_ticket_price, formatter.format(price).toString()),
                    color = White,
                    style = Name02,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
                Text(
                    text = stringResource(id = R.string.precise_store_ticket_month),
                    color = Gray500,
                    style = Body03
                )
            }
        }
    }
}

@Composable
fun PreciseStoreMoreButton(
    onClick: () -> Unit
) {
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
            text = stringResource(id = R.string.precise_store_button_more),
            color = Gray400,
            style = Body03,
            modifier = Modifier.padding(vertical = 22.dp)
        )
    }
}