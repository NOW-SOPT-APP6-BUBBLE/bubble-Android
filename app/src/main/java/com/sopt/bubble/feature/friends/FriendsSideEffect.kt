package com.sopt.bubble.feature.friends

import com.sopt.bubble.data.dto.Artist

sealed class FriendSideEffect {
    data class Success(val subsArtistList: List<Artist>, val notSubsArtistList: List<Artist>) : FriendSideEffect()

    data object Failure : FriendSideEffect()
}