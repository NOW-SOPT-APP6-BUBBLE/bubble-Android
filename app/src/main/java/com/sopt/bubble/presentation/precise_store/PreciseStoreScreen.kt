package com.sopt.bubble.presentation.precise_store

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bubble.R
import com.sopt.bubble.presentation.precise_store.PreciseStoreViewModel.Companion.INDEX_CHECKBOX01
import com.sopt.bubble.presentation.precise_store.PreciseStoreViewModel.Companion.INDEX_CHECKBOX02
import com.sopt.bubble.presentation.precise_store.PreciseStoreViewModel.Companion.INDEX_CHECKBOX03
import com.sopt.bubble.presentation.precise_store.PreciseStoreViewModel.Companion.PRECISE_STORE_BANNER_IMAGE_RATIO
import com.sopt.bubble.presentation.precise_store.PreciseStoreViewModel.Companion.PRECISE_STORE_TOP_IMAGE_RATIO
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
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            PreciseStoreTopBar(
                onClickBackIcon = {},
                onClickCloseIcon = {}
            )
        },
        bottomBar = {
            PreciseStoreBottomBar(
                isChecked = uiState.isPurchasable,
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
                        .aspectRatio(PRECISE_STORE_TOP_IMAGE_RATIO)
                )

                PreciseStoreArtistDescription(
                    uiState = uiState,
                    modifier = Modifier.padding(
                        start = 20.dp, end = 20.dp, top = 16.dp
                    )
                )
            }
            items(
                uiState.ticketList.take(
                    if (uiState.isMore) uiState.ticketList.size else 2
                )
            ) { ticket ->
                PreciseStoreTicket(
                    title = ticket.number,
                    price = ticket.price,
                    originalPrice = ticket.originalPrice,
                    modifier =
                    if (uiState.ticketList.indexOf(ticket) != 0)
                        Modifier.padding(top = 14.dp)
                    else Modifier.padding(top = 26.dp)
                )
            }

            item {
                Column(
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    if (uiState.ticketList.size > 2) {
                        PreciseStoreMoreButton(
                            isMore = uiState.isMore,
                            onClick = { viewModel.onClickMore() },
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .background(color = Gray800)
                    )

                    PreciseStoreBubbleDescription(
                        uiState = uiState,
                        modifier = Modifier.padding(
                            start = 20.dp, end = 20.dp, top = 24.dp
                        )
                    )

                    PreciseStoreCheckBoxes(
                        onClickCheckBox = { viewModel.onClickCheckBox(it) },
                        uiState = uiState,
                        modifier = Modifier.padding(
                            start = 20.dp, end = 20.dp, top = 32.dp, bottom = 47.dp
                        )
                    )
                }
            }
        }
    }
}

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
    modifier: Modifier = Modifier,
    uiState: PreciseStoreState
) {
    Column(
        modifier = modifier
    ) {
        /*아티스트 이름 텍스트*/
        Text(
            text = uiState.artistName,
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

        /*아티스트 버블 소개 텍스트*/
        Text(
            text = uiState.bubbleDescription,
            modifier = Modifier.padding(top = 20.dp),
            color = Gray300,
            style = Body03
        )

        /*아티스트 라인업 텍스트*/
        Text(
            text = stringResource(id = R.string.precise_store_artist_lineup),
            modifier = Modifier.padding(top = 18.dp),
            color = White,
            style = Body02
        )
        Text(
            text = uiState.artistLineup,
            modifier = Modifier.padding(top = 6.dp),
            color = White,
            style = Body03
        )

        /*아티스트 커밍순 텍스트*/
        if (uiState.artistComingSoon != null) {
            Text(
                text = stringResource(id = R.string.precise_store_artist_coming_soon),
                modifier = Modifier.padding(top = 18.dp),
                color = Gray500,
                style = Body02
            )
            Text(
                text = uiState.artistComingSoon,
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

@Composable
private fun PreciseStoreBubbleDescription(
    modifier: Modifier = Modifier,
    uiState: PreciseStoreState
) {

    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_precise_store_jyp_bubble),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(PRECISE_STORE_BANNER_IMAGE_RATIO),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.precise_store_bubble_introduction),
            color = White,
            style = Body02
        )

        Text(
            text = uiState.bubbleIntroduction,
            color = Gray400,
            style = Body03,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
private fun PreciseStoreCheckBoxes(
    uiState: PreciseStoreState,
    onClickCheckBox: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        PreciseStoreCheckBox(
            onClickCheckIcon = { onClickCheckBox(INDEX_CHECKBOX01) },
            isChecked = uiState.isCheckedList[INDEX_CHECKBOX01],
            title = R.string.precise_store_checkbox_title01,
            content = "textbox1"
        )
        Spacer(modifier = Modifier.height(6.dp))
        PreciseStoreCheckBox(
            onClickCheckIcon = { onClickCheckBox(INDEX_CHECKBOX02) },
            isChecked = uiState.isCheckedList[INDEX_CHECKBOX02],
            title = R.string.precise_store_checkbox_title02,
            content = "textbox2"
        )
        Spacer(modifier = Modifier.height(6.dp))
        PreciseStoreCheckBox(
            onClickCheckIcon = { onClickCheckBox(INDEX_CHECKBOX03) },
            isChecked = uiState.isCheckedList[INDEX_CHECKBOX03],
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
    isChecked: Boolean,
) {
    var isTextFolded: Boolean by remember { mutableStateOf(false) }

    val foldImageDrawRes =
        if (isTextFolded) R.drawable.ic_precise_store_fold
        else R.drawable.ic_precise_store_unfold
    val foldStringRes =
        if (isTextFolded) R.string.precise_store_content_description_fold
        else R.string.precise_store_content_description_unfold

    val checkImageRes =
        if (isChecked) R.drawable.ic_precise_store_checkbox_selected
        else R.drawable.ic_precise_store_checkbox_unselected
    val checkStringRes =
        if (isChecked) R.string.precise_store_content_description_checkbox_checked
        else R.string.precise_store_content_description_checkbox_unchecked

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
                    .noRippleClickable { isTextFolded = !isTextFolded },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = checkImageRes),
                        contentDescription = stringResource(id = checkStringRes),
                        modifier = Modifier.noRippleClickable { onClickCheckIcon() }
                    )

                    Text(
                        text = stringResource(id = title),
                        style = Body02,
                        color = White,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                Image(
                    painter = painterResource(id = foldImageDrawRes),
                    contentDescription = stringResource(id = foldStringRes),
                )
            }

            if (isTextFolded) {
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

