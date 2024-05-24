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
    @SerialName("artistMemberId")
    val artistMemberId: Int,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("imageURL")
    val imageURL: String,
    @SerialName("introduction")
    val introduction: String,
    @SerialName("isSubscribed")
    val isSubscribed: Boolean,
    @SerialName("artistName")
    val artistName: String?,
    @SerialName("artistMemberName")
    val artistMemberName: String,
)
