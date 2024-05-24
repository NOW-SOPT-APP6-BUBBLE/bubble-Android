package com.sopt.bubble.feature.friends.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.R
import com.sopt.bubble.data.dto.ArtistMemberDetail
import com.sopt.bubble.feature.frienddetail.FriendDetailSideEffect
import com.sopt.bubble.feature.frienddetail.FriendDetailState
import com.sopt.bubble.feature.friends.FriendsViewModel
import com.sopt.bubble.module.ServicePool.friendDetailService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FriendDetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<DetailState>(DetailState.Loading)
    val uiState: StateFlow<DetailState> = _uiState.asStateFlow()

    private val _postState: MutableStateFlow<FriendDetailState> =
        MutableStateFlow(FriendDetailState.Empty)
    val postState: StateFlow<FriendDetailState> get() = _postState.asStateFlow()

    private val _deleteState: MutableStateFlow<FriendDetailState> =
        MutableStateFlow(FriendDetailState.Empty)
    val deleteState: StateFlow<FriendDetailState> get() = _deleteState.asStateFlow()


    private val _sideEffect: MutableSharedFlow<FriendDetailSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<FriendDetailSideEffect> = _sideEffect


    private val _artistDetail = MutableStateFlow(
        ArtistMemberDetail(
            artistMemberId = 0,
            nickname = "",
            imageURL = "",
            introduction = "",
            isSubscribed = false,
            artistName = "",
            artistMemberName = ""
        )
    )
    val artistDetail: StateFlow<ArtistMemberDetail> = _artistDetail.asStateFlow()


    fun artistMemberInfo(artistMemberId: String) = viewModelScope.launch {
        runCatching {
            friendDetailService.artistMemberInfo(
                memberId = FriendsViewModel.MEMBER_ID,
                artistMemberId = artistMemberId.toLong(),
            )
        }.onSuccess {
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


    fun deleteStar(artistMemberId: String) {
        viewModelScope.launch {
            runCatching {
                _postState.value = FriendDetailState.Loading
                friendDetailService.postStar(MEMBER_ID, artistMemberId.toLong())
            }
                .onSuccess {
                    _sideEffect.emit(FriendDetailSideEffect.Toast(R.string.artist_profile_delete_star_success))
                    _postState.value = FriendDetailState.Success
                }
                .onFailure {
                    _sideEffect.emit(FriendDetailSideEffect.Toast(R.string.artist_profile_delete_star_failure))
                }
        }
    }

    fun postStar(artistMemberId: String) {
        viewModelScope.launch {
            runCatching {
                _deleteState.value = FriendDetailState.Loading
                friendDetailService.deleteStar(MEMBER_ID, artistMemberId.toLong())
            }
                .onSuccess {
                    _sideEffect.emit(FriendDetailSideEffect.Toast(R.string.artist_profile_post_star_success))
                    _deleteState.value = FriendDetailState.Success
                }
                .onFailure {
                    _sideEffect.emit(FriendDetailSideEffect.Toast(R.string.artist_profile_post_star_failure))
                }
        }
    }

    companion object {
        private const val MEMBER_ID = "1"
    }
}