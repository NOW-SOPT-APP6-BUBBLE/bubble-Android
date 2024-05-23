package com.sopt.bubble.feature.friends

import com.sopt.bubble.data.dto.FriendsResponseDto

sealed interface FriendState {
    data class Success(
        val subsArtistList: List<FriendsResponseDto.Result.Artist>,
        val notSubsArtistList: List<FriendsResponseDto.Result.Artist>,
    ) : FriendState

    data object Loading : FriendState
    data object Failure : FriendState
}