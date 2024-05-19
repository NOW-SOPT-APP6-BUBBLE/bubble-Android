package com.sopt.bubble.feature.more.store.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ArtistItem(
    name: String,
    photo: String,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = rememberImagePainter(data = photo),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .aspectRatio(1f),
        )
        Text(text = name)
    }
}