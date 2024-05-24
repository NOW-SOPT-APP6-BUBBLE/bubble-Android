package com.sopt.bubble.data.service

import com.sopt.bubble.data.dto.FriendsArtistDetailDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FriendsDetailService {
    @GET("api/v1/artists/artist-members/{artistMemberId}")
    suspend fun artistMemberInfo(
        @Header("memberId") memberId: String,
        @Path("artistMemberId") artistMemberId: Long,
    ): FriendsArtistDetailDto
}