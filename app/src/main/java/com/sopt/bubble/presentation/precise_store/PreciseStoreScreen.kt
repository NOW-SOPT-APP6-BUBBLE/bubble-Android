package com.sopt.bubble.presentation.precise_store

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.presentation.precise_store.model.mockTicketList
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray100
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Gray300
import com.sopt.bubble.ui.theme.Gray400
import com.sopt.bubble.ui.theme.Gray500
import com.sopt.bubble.ui.theme.Gray700
import com.sopt.bubble.ui.theme.Gray800
import com.sopt.bubble.ui.theme.Headline02
import com.sopt.bubble.ui.theme.Headline04
import com.sopt.bubble.ui.theme.Name02
import com.sopt.bubble.ui.theme.Name03
import com.sopt.bubble.ui.theme.White

@Composable
fun PreciseStoreScreen() {
    Scaffold(
        topBar = { PreciseStoreTopBar() },
        bottomBar = { PreciseStoreBottomBar() }
    ) { paddingValues ->
        val topImageRatio = 360 / 182f

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Gray700)
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(topImageRatio)
                )

                Spacer(modifier = Modifier.height(16.dp))

                PreciseStoreArtistDescription()
            }

            items(mockTicketList){ ticket ->
                PreciseStoreTicket(
                    title = ticket.number,
                    price = ticket.price,
                    originalPrice = ticket.originalPrice,
                    modifier =
                    if (mockTicketList.indexOf(ticket) != 0)
                        Modifier.padding(top = 14.dp)
                    else Modifier.padding(top = 26.dp)
                )
            }

            item {
                Column {
                    Spacer(modifier = Modifier.height(24.dp))

                    PreciseStoreMoreButton()

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .background(color = Gray800))

                    Spacer(modifier = Modifier.height(24.dp))

                    PreciseStoreBubbleDescription()

                    Spacer(modifier = Modifier.height(32.dp))

                    PreciseStoreCheckBoxes()

                    Spacer(modifier = Modifier.height(47.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreciseStoreTopBar() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = stringResource(id = R.string.app_bar_content_description_back)
                    )
                    Spacer(modifier = Modifier.width(15.dp))

                    Text(
                        text = stringResource(id = R.string.precise_store_app_bar_header),
                        style = Headline02,
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = stringResource(id = R.string.app_bar_content_description_close)
                )
            }
        }
    )
}

@Composable
private fun PreciseStoreBottomBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Gray700) // Transparent background
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    shape = RoundedCornerShape(topEnd = 18.dp),
                    color = Gray200
                )
        ) {
            Text(
                text = "이용권 구매",
                style = Headline04,
                color = White,
                modifier = Modifier.padding(vertical = 18.dp)
            )
        }
    }
}

@Composable
private fun PreciseStoreArtistDescription() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = "DAY6",
            color = White,
            style = Headline04,
            modifier = Modifier.height(32.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Gray800)
        )

        Text(
            text = "선물처럼 찾아오는 최애의 메시지와 함께하는 설레이는 일상!\n" +
                    "최애 아티스트와 나만의 특별한 프라이빗 메시지, bubble for JYPnation",
            modifier = Modifier.padding(top = 20.dp),
            color = Gray300,
            style = Body03
        )

        Text(
            text = "ARTIST 라인업",
            modifier = Modifier.padding(top = 18.dp),
            color = White,
            style = Body02
        )

        Text(
            text = "WONPIL, DOWOON",
            modifier = Modifier.padding(top = 6.dp),
            color = White,
            style = Body03
        )

        Text(
            text = "Coming soon",
            modifier = Modifier.padding(top = 18.dp),
            color = Gray500,
            style = Body02
        )
        Text(
            text = "SUNGJIN, Young K",
            modifier = Modifier.padding(top = 6.dp),
            color = Gray500,
            style = Body03
        )
    }
}

@Composable
private fun PreciseStoreTicket(
    title: String,
    price: String,
    modifier: Modifier = Modifier,
    originalPrice: String?=null,
) {
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
                text = stringResource(id = R.string.precise_store_ticket_number, title),
                color = White,
                style = Name03
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                if(originalPrice != null)
                    Text(
                        text = originalPrice,
                        color = Gray500,
                        style = Body03,)
                Text(
                    text = stringResource(id = R.string.precise_store_ticket_price, price),
                    color = White,
                    style = Name02,
                    modifier = Modifier.padding(horizontal = 5.dp))
                Text(
                    text = stringResource(id = R.string.precise_store_ticket_month),
                    color = Gray500,
                    style = Body03)
            }
        }
    }
}

@Composable
private fun PreciseStoreMoreButton() {
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

    ) {
        Text(
            text = stringResource(id = R.string.precise_store_button_more),
            color = Gray400,
            style = Body03,
            modifier = Modifier.padding(vertical = 22.dp)
        )
    }
}

@Composable
private fun PreciseStoreBubbleDescription() {
    val bannerImageRatio = 320 / 64f

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(bannerImageRatio),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "소개",
            color = White,
            style = Body02
        )

        Text(
            text = "bubble for JYPnation DAY6는 DAY6 팬들을 위한 특별한 서비스입니다.\n" +
                    "\n" +
                    "나만의 최애 DAY6 멤버가 직접 작성하는 개성 넘치는 프라이빗한 메시지를 받을 수 있습니다.\n" +
                    "\n" +
                    "bubble for JYPnation은 아티스트의 창작활동을 지원하고 응원합니다.",
            color = Gray400,
            style = Body03
        )
    }
}

@Composable
private fun PreciseStoreCheckBoxes() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        PreciseStoreCheckBox()
        Spacer(modifier = Modifier.height(6.dp))
        PreciseStoreCheckBox()
        Spacer(modifier = Modifier.height(6.dp))
        PreciseStoreCheckBox()
    }
}

@Composable
private fun PreciseStoreCheckBox() {
    Card(
        shape = RoundedCornerShape(
            topStart = 10.dp, topEnd = 10.dp,
            bottomStart = 10.dp, bottomEnd = 10.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Gray800),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 9.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_precise_store_checkbox_unselected
                        ),
                        contentDescription = stringResource(
                            id = R.string.precise_store_content_description_checkbox_unchecked
                        )
                    )
                    
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "서비스 이용안내 동의",
                        style = Body02,
                        color = White
                    )
                }

                Image(
                    painter = painterResource(
                        id = R.drawable.ic_precise_store_unfold),
                    contentDescription = stringResource(
                        id = R.string.precise_store_content_description_unfold))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreciseScreenPreview() {
    PreciseStoreScreen()
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    PreciseStoreCheckBox()
}