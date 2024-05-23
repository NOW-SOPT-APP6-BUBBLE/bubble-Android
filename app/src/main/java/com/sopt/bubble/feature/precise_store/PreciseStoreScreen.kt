package com.sopt.bubble.feature.precise_store

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sopt.bubble.R
import com.sopt.bubble.data.dto.response.ResponsePreciseArtistDto
import com.sopt.bubble.feature.precise_store.PreciseStoreViewModel.Companion.CHECK_BUTTON_NUM
import com.sopt.bubble.feature.precise_store.PreciseStoreViewModel.Companion.MORE_UNFOLD_ITEM_LIMIT
import com.sopt.bubble.feature.precise_store.PreciseStoreViewModel.Companion.PRECISE_STORE_BANNER_IMAGE_RATIO
import com.sopt.bubble.feature.precise_store.PreciseStoreViewModel.Companion.PRECISE_STORE_TOP_IMAGE_RATIO
import com.sopt.bubble.feature.precise_store.component.PreciseStoreBottomBar
import com.sopt.bubble.feature.precise_store.component.PreciseStoreCheckBox
import com.sopt.bubble.feature.precise_store.component.PreciseStoreMoreButton
import com.sopt.bubble.feature.precise_store.component.PreciseStoreTicket
import com.sopt.bubble.feature.precise_store.component.PreciseStoreTopBar
import com.sopt.bubble.feature.precise_store.model.checkBoxList
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray300
import com.sopt.bubble.ui.theme.Gray400
import com.sopt.bubble.ui.theme.Gray500
import com.sopt.bubble.ui.theme.Gray700
import com.sopt.bubble.ui.theme.Gray800
import com.sopt.bubble.ui.theme.Headline04
import com.sopt.bubble.ui.theme.White

@Composable
fun PreciseStoreScreen(
    modifier: Modifier = Modifier,
    viewModel: PreciseStoreViewModel = viewModel(),
    navController: NavController = rememberNavController(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val artistId: Long = 3

    LaunchedEffect(key1 = artistId) {
        viewModel.getPreciseArtistInformation(artistId = artistId)
    }

    Scaffold(
        topBar = {
            PreciseStoreTopBar(
                onClickBackIcon = { navController.navigateUp() },
                onClickCloseIcon = { navController.navigateUp() })
        }
    ) { paddingValues ->
        when (uiState) {
            is PreciseStoreState.SuccessState -> {
                PreciseStoreSuccessScreen(
                    modifier = modifier.padding(paddingValues),
                    uiState = uiState as PreciseStoreState.SuccessState,
                    onClickCheckBox = { viewModel.onClickCheckBox(it) }
                )
            }

            is PreciseStoreState.LoadingState -> {
                PreciseStoreFailureScreen(
                    modifier = modifier.padding(paddingValues)
                )
            }

            is PreciseStoreState.ErrorState -> {
                PreciseStoreFailureScreen(
                    modifier = modifier.padding(paddingValues)
                )
            }
        }
    }
}

@Composable
fun PreciseStoreFailureScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Gray700)
    ) {

    }
}

@Composable
fun PreciseStoreSuccessScreen(
    modifier: Modifier = Modifier,
    uiState: PreciseStoreState.SuccessState,
    onClickCheckBox: (Int) -> Unit,
    onClickBottomBar: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Scaffold(
        bottomBar = {
            PreciseStoreBottomBar(
                isChecked = uiState.isPurchasable,
                onClick = { onClickBottomBar() })
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .background(Gray700)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(uiState.photo)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(PRECISE_STORE_TOP_IMAGE_RATIO)
            )

            PreciseStoreArtistDescription(
                artistName = uiState.name,
                bubbleDescription = uiState.bubbleDescription,
                serviceMember = uiState.isServiceMember,
                nonServiceMember = uiState.isNotServiceMember,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 16.dp)
            )

            PreciseMoreView(subscribeList = uiState.subscribes)

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(color = Gray800)
            )

            PreciseStoreBubbleDescription(
                description = uiState.description,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 24.dp)
            )


            PreciseStoreCheckBoxes(
                onClickCheckBox = { onClickCheckBox(it) },
                isCheckedList = uiState.isCheckedList,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(
                        top = 32.dp,
                        bottom = 47.dp
                    )
            )
        }
    }
}

@Composable
private fun PreciseStoreArtistDescription(
    artistName: String,
    bubbleDescription: String,
    serviceMember: String,
    nonServiceMember: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        /*아티스트 이름 텍스트*/
        Text(
            text = artistName.ifEmpty { "" },
            color = White,
            style = Headline04,
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(1.dp)
                .background(color = Gray800)
        )

        /*아티스트 버블 소개 텍스트*/
        Text(
            text = bubbleDescription,
            color = Gray300,
            style = Body03,
            modifier = Modifier.padding(top = 20.dp)
        )

        /*아티스트 라인업 텍스트*/
        Text(
            text = stringResource(id = R.string.precise_store_artist_lineup),
            color = White,
            style = Body02,
            modifier = Modifier.padding(top = 18.dp),
        )

        Text(
            text = serviceMember,
            color = White,
            style = Body03,
            modifier = Modifier.padding(top = 6.dp)
        )

        /*아티스트 커밍순 텍스트*/
        if (nonServiceMember.isNotBlank()) {
            Text(
                text = stringResource(id = R.string.precise_store_artist_coming_soon),
                color = Gray500,
                style = Body02,
                modifier = Modifier.padding(top = 18.dp)
            )
            Text(
                text = nonServiceMember,
                color = Gray500,
                style = Body03,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }
}

@Composable
private fun PreciseMoreView(
    subscribeList: List<ResponsePreciseArtistDto.Result.Artist.Subscribe>
) {
    var isMorePressed by remember { mutableStateOf(false) }
    val moreIndex =
        if (subscribeList.size < MORE_UNFOLD_ITEM_LIMIT || isMorePressed) subscribeList.size
        else MORE_UNFOLD_ITEM_LIMIT

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
            PreciseStoreTicket(
                title = subscribe.name,
                price = subscribe.price,
                originalPrice = subscribe.previousPrice,
                modifier = if (subscribeList.indexOf(subscribe) != 0) Modifier.padding(top = 14.dp)
                else Modifier.padding(top = 26.dp)
            )
        }
    }

    if (!isMorePressed && subscribeList.size > MORE_UNFOLD_ITEM_LIMIT) {
        PreciseStoreMoreButton(onClick = { isMorePressed = !isMorePressed })
    } else {
        Spacer(modifier = Modifier.height(26.dp))
    }
}

@Composable
private fun PreciseStoreBubbleDescription(
    description: String,
    modifier: Modifier = Modifier
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
            text = description,
            color = Gray400,
            style = Body03,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
private fun PreciseStoreCheckBoxes(
    isCheckedList: List<Boolean>,
    onClickCheckBox: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        for (index in 0..<CHECK_BUTTON_NUM) {
            with(checkBoxList[index]) {
                PreciseStoreCheckBox(
                    checkBoxContent = this,
                    isChecked = isCheckedList[index],
                    onClickCheckBox = { onClickCheckBox(index) }
                )

                if (index < CHECK_BUTTON_NUM - 1) {
                    Spacer(modifier = Modifier.height(6.dp))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrecisePreview() {
    PreciseStoreScreen()
}