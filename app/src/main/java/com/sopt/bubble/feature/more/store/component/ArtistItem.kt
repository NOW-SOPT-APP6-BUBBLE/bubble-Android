package com.sopt.bubble.feature.more.store.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Name02

@Composable
fun ArtistItem(
    name: String,
    photo: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(data = photo),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(2.3f),
                contentScale = ContentScale.FillWidth,
            )
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(
                        vertical = 13.dp,
                        horizontal = 16.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_store_bubble),
                        contentDescription = null
                    )
                    Spacer(modifier = modifier.padding(4.dp))
                    Text(
                        text = name,
                        style = Name02
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_store_arrow),
                    contentDescription = null
                )
            }
        }
    }
}