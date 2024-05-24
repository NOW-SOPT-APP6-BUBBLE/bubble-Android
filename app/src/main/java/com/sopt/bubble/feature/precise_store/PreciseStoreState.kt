package com.sopt.bubble.feature.precise_store

import com.sopt.bubble.data.dto.response.ResponsePreciseArtistDto
import kotlinx.serialization.SerialName


sealed interface PreciseStoreState {
    data class SuccessState(
        val name: String,
        val description: String,
        val photo: String,
        val subscribes: List<ResponsePreciseArtistDto.Result.Artist.Subscribe>,
        val isServiceMember: String,
        val isNotServiceMember: String,
        val bubbleDescription: String = "선물처럼 찾아오는 최애의 메시지와 함께하는 설레이는 일상!\n" +
                "최애 아티스트와 나만의 특별한 프라이빗 메시지, bubble for JYPnation",
        val isCheckedList: List<Boolean> = listOf(false, false, false),
        val isPurchasable: Boolean = false,
    ): PreciseStoreState

    data object LoadingState : PreciseStoreState
    data object ErrorState : PreciseStoreState
}
