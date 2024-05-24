package com.sopt.bubble.feature.precise_store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sopt.bubble.R
import com.sopt.bubble.feature.precise_store.PreciseStoreViewModel.Companion.PRECISE_STORE_TOP_IMAGE_RATIO
import com.sopt.bubble.feature.precise_store.component.PreciseMoreSubscribeView
import com.sopt.bubble.feature.precise_store.component.PreciseStoreArtistDescriptionView
import com.sopt.bubble.feature.precise_store.component.PreciseStoreBottomBar
import com.sopt.bubble.feature.precise_store.component.PreciseStoreBubbleDescriptionView
import com.sopt.bubble.feature.precise_store.component.PreciseStoreCheckBoxView
import com.sopt.bubble.feature.precise_store.component.PreciseStoreTopBar
import com.sopt.bubble.ui.theme.Gray700
import com.sopt.bubble.ui.theme.Gray800

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

            PreciseStoreArtistDescriptionView(
                artistName = uiState.name,
                bubbleDescription = uiState.bubbleDescription,
                serviceMember = uiState.isServiceMember,
                nonServiceMember = uiState.isNotServiceMember,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 16.dp)
            )

            PreciseMoreSubscribeView(subscribeList = uiState.subscribes)

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(color = Gray800)
            )

            PreciseStoreBubbleDescriptionView(
                description = uiState.description,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 24.dp)
            )


            PreciseStoreCheckBoxView(
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



@Preview(showBackground = true)
@Composable
fun PrecisePreview() {
    PreciseStoreScreen()
}