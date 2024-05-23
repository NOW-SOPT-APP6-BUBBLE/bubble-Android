package com.sopt.bubble.data.service

import com.sopt.bubble.data.dto.response.FriendDetailResponseDto
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface FriendDetailService {
    @POST("api/v1/artists/artist-members/friend/{artistMemberId}")
    suspend fun postStar(
        @Header("memberId") memberId: String,
        @Path("artistMemberId") artistMemberId: Long,
    ): Response<FriendDetailResponseDto>

    @DELETE("api/v1/artists/artist-members/friend/{artistMemberId}")
    suspend fun deleteStar(
        @Header("memberId") memberId: String,
        @Path("artistMemberId") artistMemberId: Long,
    ): Response<FriendDetailResponseDto>
}