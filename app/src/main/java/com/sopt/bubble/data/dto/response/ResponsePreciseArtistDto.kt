package com.sopt.bubble.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponsePreciseArtistDto(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: Result,
){
    @Serializable
    data class Result(
        @SerialName("artist")
        val artist: Artist
    ) {
        @Serializable
        data class Artist(
            @SerialName("name")
            val name: String,
            @SerialName("description")
            val description: String,
            @SerialName("photo")
            val photo: String,
            @SerialName("subscribe")
            val subscribes: List<Subscribe>,
            @SerialName("isServiceMembers")
            val isServiceMember: List<String>,
            @SerialName("isNotServiceMembers")
            val isNotServiceMember: List<String>
        ) {
            @Serializable
            data class Subscribe(
                @SerialName("name")
                val name: String,
                @SerialName("previousPrice")
                val previousPrice: Int,
                @SerialName("price")
                val price: Int
            )
        }
    }
}