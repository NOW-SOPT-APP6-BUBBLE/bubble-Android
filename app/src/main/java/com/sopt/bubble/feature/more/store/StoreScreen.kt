package com.sopt.bubble.feature.more.store

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bubble.R
import com.sopt.bubble.feature.more.store.component.ArtistItem
import com.sopt.bubble.feature.more.store.component.StoreTopBar
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.BubbleAndroidTheme
import com.sopt.bubble.ui.theme.Gray100

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
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 20.dp)
            ) {
                items(storeViewModel.artistList) { artistInfo ->
                    ArtistItem(
                        name = artistInfo.name,
                        photo = artistInfo.photo,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Column(
                modifier = modifier
                    .background(color = Gray100)
                    .padding(bottom = 23.dp)
            ) {
                Text(
                    modifier = modifier.padding(bottom = 17.dp),
                    text = stringResource(id = R.string.store_bottom_1),
                    style = Body03
                )
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