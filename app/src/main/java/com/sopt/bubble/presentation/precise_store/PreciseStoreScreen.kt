package com.sopt.bubble.presentation.precise_store

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.presentation.precise_store.model.mockTicketList
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray300
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
        topBar = { PreciseStoreTopBar() }
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

                PreciseStoreArtistDescriptionView()
            }

            items(mockTicketList){ ticket ->
                PreciseStoreTicketView(
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
private fun PreciseStoreArtistDescriptionView() {
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
private fun PreciseStoreTicketView(
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


@Preview(showBackground = true)
@Composable
fun PreciseScreenPreview() {
    PreciseStoreScreen()
}