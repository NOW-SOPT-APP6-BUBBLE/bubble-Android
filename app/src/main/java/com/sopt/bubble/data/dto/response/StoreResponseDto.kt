package com.sopt.bubble.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreResponseDto(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: Result,
) {
    @Serializable
    data class Result(
        @SerialName("artists")
        val artists: List<Artist>
    ) {
        @Serializable
        data class Artist(
            @SerialName("artistId")
            val artistId: Long,
            @SerialName("name")
            val name: String,
            @SerialName("photo")
            val photo: String,
        )
    }
}