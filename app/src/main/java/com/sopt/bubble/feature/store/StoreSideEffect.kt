package com.sopt.bubble.feature.store

import com.sopt.bubble.data.dto.response.StoreResponseDto

sealed class StoreSideEffect {
    data class Success(val artistList: List<StoreResponseDto.Result.Artist>) :
        StoreSideEffect()

    data object Failure : StoreSideEffect()
}