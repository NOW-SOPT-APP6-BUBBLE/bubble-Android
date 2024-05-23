package com.sopt.bubble.data.service

import com.sopt.bubble.data.dto.FriendsResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface FriendsService {
    @GET("api/v1/artists/artist-members")
    suspend fun getFriends(
        @Header("memberId") memberId: String,
    ): FriendsResponseDto
}