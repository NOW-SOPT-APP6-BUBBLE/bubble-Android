package com.sopt.bubble.feature.precise_store

import com.sopt.bubble.data.dto.response.ResponsePreciseArtistDto
import com.sopt.bubble.feature.precise_store.model.Ticket


sealed interface PreciseStoreState{
    data class SuccessState(
        val isCheckedList: List<Boolean> = listOf(false, false, false),
        val isMore: Boolean = false,
        val isPurchasable: Boolean = false,
        val bubbleDescription:String = "선물처럼 찾아오는 최애의 메시지와 함께하는 설레이는 일상!\n" +
                "최애 아티스트와 나만의 특별한 프라이빗 메시지, bubble for JYPnation",
        val artistInformation: ResponsePreciseArtistDto.Result.Artist,
        val ticketList: List<Ticket> = listOf()
    ):PreciseStoreState

    data object LoadingState: PreciseStoreState
    data object ErrorState: PreciseStoreState
}
