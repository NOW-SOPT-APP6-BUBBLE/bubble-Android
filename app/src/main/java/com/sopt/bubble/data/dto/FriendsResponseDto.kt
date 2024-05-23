package com.sopt.bubble.data.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FriendsResponseDto(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: Result
)

@Serializable
data class Result(
    @SerialName("isSubsArtists")
    val isSubsArtists: List<Artist>,
    @SerialName("isNotSubsArtists")
    val isNotSubsArtists: List<Artist>
)

@Serializable
data class Artist(
    @SerialName("artistMemberId")
    val artistMemberId: Int,
    @SerialName("name")
    val name: String,
    @SerialName("imageURL")
    val imageURL: String,
    @SerialName("introduction")
    val introduction: String
)
