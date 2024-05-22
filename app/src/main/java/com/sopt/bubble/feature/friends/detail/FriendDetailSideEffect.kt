package com.sopt.bubble.feature.friends.detail

sealed class FriendDetailSideEffect {
//    data class Success(val artistList: List<StoreResponseDto.Result.Artist>) :
//        FriendDetailSideEffect()

    data object Failure : FriendDetailSideEffect()
}