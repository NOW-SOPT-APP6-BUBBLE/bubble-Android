package com.sopt.bubble.presentation.precise_store

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.lifecycle.viewmodel.compose.viewModel
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.presentation.precise_store.model.mockTicketList1
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Gray300
import com.sopt.bubble.ui.theme.Gray400
import com.sopt.bubble.ui.theme.Gray500
import com.sopt.bubble.ui.theme.Gray700
import com.sopt.bubble.ui.theme.Gray800
import com.sopt.bubble.ui.theme.Headline02
import com.sopt.bubble.ui.theme.Headline04
import com.sopt.bubble.ui.theme.JYPBLUE
import com.sopt.bubble.ui.theme.Name02
import com.sopt.bubble.ui.theme.Name03
import com.sopt.bubble.ui.theme.White
import com.sopt.bubble.util.extension.noRippleClickable

@Composable
fun PreciseStoreScreen(
    viewModel: PreciseStoreViewModel = viewModel()
) {
    val topImageRatio = 360 / 182f

    var isChecked1: Boolean by remember { mutableStateOf(false) }
    var isChecked2: Boolean by remember { mutableStateOf(false) }
    var isChecked3: Boolean by remember { mutableStateOf(false) }
    var isFolded1: Boolean by remember { mutableStateOf(false) }
    var isFolded2: Boolean by remember { mutableStateOf(false) }
    var isFolded3: Boolean by remember { mutableStateOf(false) }

    val list = mockTicketList1

    var isMore: Boolean by remember { mutableStateOf(false) }
    var maxTicketNum: Int by remember { mutableIntStateOf(2) }

    Scaffold(
        topBar = {
            PreciseStoreTopBar(
                onClickBack = {},
                onClickClose = {}
            )
        },
        bottomBar = {
            PreciseStoreBottomBar(
                isChecked = isChecked1 && isChecked2 && isChecked3,
                onClick = {}
            )
        }
    ) { paddingValues ->
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
            items(list.take(maxTicketNum)) { ticket ->
                PreciseStoreTicket(
                    title = ticket.number,
                    price = ticket.price,
                    originalPrice = ticket.originalPrice,
                    modifier =
                    if (list.indexOf(ticket) != 0)
                        Modifier.padding(top = 14.dp)
                    else Modifier.padding(top = 26.dp)
                )
            }

            item {
                Column {
                    Spacer(modifier = Modifier.height(24.dp))

                    if (list.size > 2) {
                        PreciseStoreMoreButton(
                            isMore = isMore,
                            onClick = {
                                isMore = !isMore
                                maxTicketNum = if (isMore) list.size else 2
                            },
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .background(color = Gray800)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    PreciseStoreBubbleDescription()

                    Spacer(modifier = Modifier.height(32.dp))

                    PreciseStoreCheckBoxes(
                        isChecked01 = isChecked1,
                        isChecked02 = isChecked2,
                        isChecked03 = isChecked3,
                        onClickCheckBox1 = { isChecked1 = !isChecked1 },
                        onClickCheckBox2 = { isChecked2 = !isChecked2 },
                        onClickCheckBox3 = { isChecked3 = !isChecked3 },
                        isFolded1 = isFolded1,
                        isFolded2 = isFolded2,
                        isFolded3 = isFolded3,
                        onClickFold1 = { isFolded1 = !isFolded1 },
                        onClickFold2 = { isFolded2 = !isFolded2 },
                        onClickFold3 = { isFolded3 = !isFolded3 }

                    )

                    Spacer(modifier = Modifier.height(47.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreciseStoreTopBar(
    onClickBack: () -> Unit,
    onClickClose: () -> Unit,
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
                        modifier = Modifier.noRippleClickable { onClickBack() }

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
                    modifier = Modifier.noRippleClickable { onClickClose() }
                )
            }
        }
    )
}

@Composable
private fun PreciseStoreBottomBar(
    isChecked: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Gray700) // Transparent background
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
                text = "이용권 구매",
                style = Headline04,
                color = White,
                modifier = Modifier.padding(vertical = 18.dp)
            )
        }
    }
}

@Composable
private fun PreciseStoreArtistDescription(
    artistName: String = "DAY6",
    bubbleDescription: String = "선물처럼 찾아오는 최애의 메시지와 함께하는 설레이는 일상!\n" +
            "최애 아티스트와 나만의 특별한 프라이빗 메시지, bubble for JYPnation",
    artistLineup: String = "WONPIL, DOWOON",
    artistComingSoon: String? = "SUNGJIN, Young K"

) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = artistName,
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
            text = bubbleDescription,
            modifier = Modifier.padding(top = 20.dp),
            color = Gray300,
            style = Body03
        )

        Text(
            text = stringResource(id = R.string.precise_store_artist_lineup),
            modifier = Modifier.padding(top = 18.dp),
            color = White,
            style = Body02
        )

        Text(
            text = artistLineup,
            modifier = Modifier.padding(top = 6.dp),
            color = White,
            style = Body03
        )

        if (artistComingSoon != null) {
            Text(
                text = stringResource(id = R.string.precise_store_artist_coming_soon),
                modifier = Modifier.padding(top = 18.dp),
                color = Gray500,
                style = Body02
            )
            Text(
                text = artistComingSoon,
                modifier = Modifier.padding(top = 6.dp),
                color = Gray500,
                style = Body03
            )
        }


    }
}

@Composable
private fun PreciseStoreTicket(
    title: String,
    price: String,
    modifier: Modifier = Modifier,
    originalPrice: String? = null,
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
            ) {
                if (originalPrice != null)
                    Text(
                        text = originalPrice,
                        color = Gray500,
                        style = Body03,
                    )
                Text(
                    text = stringResource(id = R.string.precise_store_ticket_price, price),
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
private fun PreciseStoreMoreButton(
    isMore: Boolean,
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
        if (isMore) {
            Text(
                text = stringResource(id = R.string.precise_store_button_more_close),
                color = Gray400,
                style = Body03,
                modifier = Modifier.padding(vertical = 22.dp)
            )
        } else {
            Text(
                text = stringResource(id = R.string.precise_store_button_more),
                color = Gray400,
                style = Body03,
                modifier = Modifier.padding(vertical = 22.dp)
            )
        }


    }
}

@Composable
private fun PreciseStoreBubbleDescription(
    bubbleIntroduction: String = "bubble for JYPnation DAY6는 DAY6 팬들을 위한 특별한 서비스입니다.\n" +
            "\n" +
            "나만의 최애 DAY6 멤버가 직접 작성하는 개성 넘치는 프라이빗한 메시지를 받을 수 있습니다.\n" +
            "\n" +
            "bubble for JYPnation은 아티스트의 창작활동을 지원하고 응원합니다."
) {
    val bannerImageRatio = 320 / 64f

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_precise_store_jyp_bubble),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(bannerImageRatio),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.precise_store_bubble_introduction),
            color = White,
            style = Body02
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = bubbleIntroduction,
            color = Gray400,
            style = Body03
        )
    }
}

@Composable
private fun PreciseStoreCheckBoxes(
    onClickCheckBox1: () -> Unit,
    onClickCheckBox2: () -> Unit,
    onClickCheckBox3: () -> Unit,
    isChecked01: Boolean,
    isChecked02: Boolean,
    isChecked03: Boolean,
    onClickFold1: () -> Unit,
    onClickFold2: () -> Unit,
    onClickFold3: () -> Unit,
    isFolded1: Boolean,
    isFolded2: Boolean,
    isFolded3: Boolean,
) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        PreciseStoreCheckBox(
            onClickCheckIcon = onClickCheckBox1,
            isChecked = isChecked01,
            onClickFold = onClickFold1,
            isFolded = isFolded1,
            title = R.string.precise_store_checkbox_title01,
            content = "textbox1"
        )
        Spacer(modifier = Modifier.height(6.dp))
        PreciseStoreCheckBox(
            onClickCheckIcon = onClickCheckBox2,
            isChecked = isChecked02,
            onClickFold = onClickFold2,
            isFolded = isFolded2,
            title = R.string.precise_store_checkbox_title02,
            content = "textbox2"
        )
        Spacer(modifier = Modifier.height(6.dp))
        PreciseStoreCheckBox(
            onClickCheckIcon = onClickCheckBox3,
            isChecked = isChecked03,
            onClickFold = onClickFold3,
            isFolded = isFolded3,
            title = R.string.precise_store_checkbox_title03,
            content = "textbox3"
        )
    }
}

@Composable
private fun PreciseStoreCheckBox(
    @StringRes
    title: Int,
    content: String,
    onClickCheckIcon: () -> Unit,
    onClickFold: () -> Unit,
    isChecked: Boolean,
    isFolded: Boolean,
) {
    val checkImageId = if (isChecked) R.drawable.ic_precise_store_checkbox_selected
    else R.drawable.ic_precise_store_checkbox_unselected
    val checkStringId = if (isChecked) R.string.precise_store_content_description_checkbox_checked
    else R.string.precise_store_content_description_checkbox_unchecked

    val foldImageId = if (isFolded) R.drawable.ic_precise_store_fold
    else R.drawable.ic_precise_store_unfold
    val foldStringId = if (isFolded) R.string.precise_store_content_description_fold
    else R.string.precise_store_content_description_unfold


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
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable { onClickFold() },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = checkImageId),
                        contentDescription = stringResource(id = checkStringId),
                        modifier = Modifier.noRippleClickable { onClickCheckIcon() }
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = stringResource(id = title),
                        style = Body02,
                        color = White
                    )
                }

                Image(
                    painter = painterResource(id = foldImageId),
                    contentDescription = stringResource(id = foldStringId),
                )
            }
            if (isFolded) {
                Text(
                    text = content,
                    style = Body03,
                    color = White,
                    modifier = Modifier.padding(
                        top = 12.dp, start = 1.dp, end = 1.dp, bottom = 11.dp
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreciseScreenPreview() {
    PreciseStoreScreen()
}

