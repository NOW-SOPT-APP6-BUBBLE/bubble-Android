package com.sopt.bubble.feature.friends

import com.sopt.bubble.data.dto.Artist

sealed class FriendSideEffect {
    data class Success(val artistList: List<Artist>) : FriendSideEffect()

    data object Failure : FriendSideEffect()
}