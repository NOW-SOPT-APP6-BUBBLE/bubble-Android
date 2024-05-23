package com.sopt.bubble.feature.friends.detail

import com.sopt.bubble.data.dto.ArtistMemberDetail

sealed interface DetailState {
    data class Success(val artistMemberDetail: ArtistMemberDetail) : DetailState
    data object Loading : DetailState
    data object Failure : DetailState
}
