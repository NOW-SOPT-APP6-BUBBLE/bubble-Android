package com.sopt.bubble.feature.more.store

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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bubble.R
import com.sopt.bubble.feature.more.store.component.ArtistItem
import com.sopt.bubble.feature.more.store.component.StoreBottomBar
import com.sopt.bubble.feature.more.store.component.StoreTopBar
import com.sopt.bubble.ui.theme.BubbleAndroidTheme

@Composable
fun StoreScreen(
    modifier: Modifier = Modifier,
    storeViewModel: StoreViewModel = viewModel()
) {
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
            LazyColumn {
                storeViewModel.artistList.forEachIndexed { index, artistInfo ->
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
                        if (index == storeViewModel.artistList.size - 1) {
                            Spacer(modifier = Modifier.height(24.dp))
                        } else {
                            Spacer(modifier = Modifier.height(18.dp))
                        }
                    }
                }
                item {
                    StoreBottomBar(modifier)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun StorePreview() {
    BubbleAndroidTheme {
        StoreScreen()
    }
}