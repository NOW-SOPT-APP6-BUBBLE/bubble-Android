package com.sopt.bubble.feature.more.store

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bubble.R
import com.sopt.bubble.feature.more.store.component.ArtistItem
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
        ) {
            Image(
                modifier = modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.img_store_banner),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
            LazyColumn(
                modifier = modifier.fillMaxSize()
            ) {
                items(storeViewModel.artistList) { artistInfo ->
                    ArtistItem(
                        name = artistInfo.name,
                        photo = artistInfo.photo
                    )
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