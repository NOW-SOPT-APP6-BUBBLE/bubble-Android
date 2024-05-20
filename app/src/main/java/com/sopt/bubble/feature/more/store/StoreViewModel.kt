package com.sopt.bubble.feature.more.store

import androidx.lifecycle.ViewModel
import com.sopt.bubble.data.dataclass.StoreArtist

class StoreViewModel : ViewModel() {

    val artistList = listOf(
        StoreArtist(
            name = "YAOCHEN",
            photo = "https://github.com/NOW-SOPT-APP6-BUBBLE/bubble-Android/assets/128459613/20e22f1f-0720-4916-b608-1af8202ab506",
        ),
        StoreArtist(
            name = "NMIXX",
            photo = "https://github.com/NOW-SOPT-APP6-BUBBLE/bubble-Android/assets/128459613/b486ec10-6d0b-4415-a740-c34c86c2cda4"
        ),
        StoreArtist(
            name = "BOY STORY",
            photo = "https://github.com/NOW-SOPT-APP6-BUBBLE/bubble-Android/assets/128459613/d2a2ed1c-b140-473f-bc2e-da3da93b481c"
        ),
        StoreArtist(
            name = "Xdinary Heroes",
            photo = "https://github.com/NOW-SOPT-APP6-BUBBLE/bubble-Android/assets/128459613/78a4fcae-ede0-435c-aa2c-b5241e08495a"
        ),
        StoreArtist(
            name = "J.Y. Park",
            photo = "https://github.com/NOW-SOPT-APP6-BUBBLE/bubble-Android/assets/128459613/b486ec10-6d0b-4415-a740-c34c86c2cda4"
        ),
        StoreArtist(
            name = "Stray Kids",
            photo = "https://github.com/NOW-SOPT-APP6-BUBBLE/bubble-Android/assets/128459613/c98dc277-f492-48c9-b0d8-188884d8b551"
        ),

        )
}