package com.sopt.bubble.feature.store

import com.sopt.bubble.data.dto.response.StoreResponseDto

sealed class StoreState {
    data class Success(val artistList: List<StoreResponseDto.Result.Artist>) :
        StoreState()

    data object Failure : StoreState()
}