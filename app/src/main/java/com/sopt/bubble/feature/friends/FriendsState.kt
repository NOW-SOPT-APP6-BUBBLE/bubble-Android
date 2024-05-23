package com.sopt.bubble.feature.friends

import com.sopt.bubble.data.dto.Artist

sealed interface FriendState {
    data class Success(val subsArtistList: List<Artist>, val notSubsArtistList: List<Artist>) : FriendState
    data object Loading : FriendState
    data object Failure : FriendState
}