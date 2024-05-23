package com.sopt.bubble.data.dto

data class FriendsArtistDetailDto(
    val status: Int,
    val success: Boolean,
    val message: String,
    val result: ArtistMemberDetail
)

data class ArtistMemberDetail(
    val artistMemberId: Int,
    val nickname: String,
    val imageURL: String,
    val introduction: String,
    val isSubscribed: Boolean,
    val artistName: String?,
    val artistMemberName: String
)
