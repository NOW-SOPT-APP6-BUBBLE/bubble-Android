package com.sopt.bubble.feature.friends.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.data.dto.ArtistMemberDetail
import com.sopt.bubble.feature.friends.FriendsViewModel.FriendsComponentConstants.MEMBER_ID
import com.sopt.bubble.module.ServicePool.friendDetailService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<DetailState>(DetailState.Loading)
    val uiState: StateFlow<DetailState> = _uiState.asStateFlow()

    private val _artistDetail = MutableStateFlow(ArtistMemberDetail())
    val artistDetail: StateFlow<ArtistMemberDetail> = _artistDetail.asStateFlow()

    fun artistMemberInfo(artistMemberId: Long) {
        viewModelScope.launch {
            runCatching {
                friendDetailService.artistMemberInfo(
                    memberId = MEMBER_ID,
                    artistMemberId = artistMemberId
                )
            }
                .onSuccess {
                    _uiState.emit(
                        DetailState.Success(
                            it.result
                        )
                    )
                    _artistDetail.value = it.result
                }
                .onFailure {
                    _uiState.emit(DetailState.Failure)
                }
        }
    }
}