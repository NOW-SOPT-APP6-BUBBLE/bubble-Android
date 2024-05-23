package com.sopt.bubble.feature.store

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bubble.R
import com.sopt.bubble.data.dto.response.StoreResponseDto
import com.sopt.bubble.feature.store.component.ArtistItem
import com.sopt.bubble.feature.store.component.StoreBottomBar
import com.sopt.bubble.feature.store.component.StoreTopBar
import com.sopt.bubble.util.extension.toast
import kotlinx.coroutines.launch

@Composable
fun StoreRoute(
    modifier: Modifier = Modifier,
    storeViewModel: StoreViewModel = viewModel()
) {

    var artistList by remember { mutableStateOf<List<StoreResponseDto.Result.Artist>>(emptyList()) }

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(true) {
        storeViewModel.getArtistInfo()
    }

    LaunchedEffect(storeViewModel.sideEffect, lifecycleOwner) {
        storeViewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is StoreSideEffect.Success -> {
                        artistList = sideEffect.artistList
                        context.toast(R.string.server_success)
                    }

                    StoreSideEffect.Failure -> context.toast(R.string.server_failure)
                }
            }
    }

    StoreScreen(
        modifier = modifier,
        artistList = artistList
    )
}

@Composable
fun StoreScreen(
    modifier: Modifier = Modifier,
    artistList: List<StoreResponseDto.Result.Artist>
) {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { StoreTopBar(modifier) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Image(
                modifier = modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.img_store_banner),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
            LazyColumn(state = scrollState) {
                artistList.forEachIndexed { index, artistInfo ->
                    item {
                        if (index == 0) {
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                        ) {
                            ArtistItem(
                                name = artistInfo.name,
                                photo = artistInfo.photo
                            )
                        }
                        if (index == artistList.size - 1) {
                            Spacer(modifier = Modifier.height(24.dp))
                        } else {
                            Spacer(modifier = Modifier.height(18.dp))
                        }
                    }
                }
                item {
                    StoreBottomBar(modifier = modifier,
                        onScrollToTop = {
                            coroutineScope.launch {
                                scrollState.animateScrollToItem(index = 0)
                            }
                        }
                    )
                }
            }
        }
    }
}