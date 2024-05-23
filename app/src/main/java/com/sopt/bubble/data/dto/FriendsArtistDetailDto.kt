package com.sopt.bubble.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FriendsArtistDetailDto(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: ArtistMemberDetail,
)

@Serializable
data class ArtistMemberDetail(
    val artistMemberId: Int = 0,
    val nickname: String = "",
    val imageURL: String = "",
    val introduction: String = "",
    val isSubscribed: Boolean = false,
    val artistName: String? = "",
    val artistMemberName: String = "",
)
