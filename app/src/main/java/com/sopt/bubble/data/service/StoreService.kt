package com.sopt.bubble.data.service

import com.sopt.bubble.data.dto.response.StoreResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface StoreService {
    @GET("api/v1/artists")
    suspend fun getArtistListFromServer(
        @Header("memberId") memberId: String
    ): StoreResponseDto
}