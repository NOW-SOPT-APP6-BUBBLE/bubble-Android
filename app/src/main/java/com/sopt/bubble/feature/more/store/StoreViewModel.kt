package com.sopt.bubble.feature.more.store

import androidx.lifecycle.ViewModel
import com.sopt.bubble.R
import com.sopt.bubble.data.dataclass.StoreArtist

class StoreViewModel : ViewModel() {

    val artistList = listOf(
        StoreArtist(
            name = "YAOCHEN",
            photo = "https://github.com/NOW-SOPT-APP6-BUBBLE/bubble-Android/assets/128459613/20e22f1f-0720-4916-b608-1af8202ab506",
        )
    )
}