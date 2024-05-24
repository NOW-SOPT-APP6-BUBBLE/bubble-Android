package com.sopt.bubble.data.service

import com.sopt.bubble.data.dto.response.ResponsePreciseArtistDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface PreciseStoreService {
    @GET("/api/v1/artists/{artistId}")
    suspend fun getPreciseArtistInformation(
        @Header("memberId") memberId: String,
        @Path("artistId") artistId: Long
    ): ResponsePreciseArtistDto
}