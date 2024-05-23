package com.sopt.bubble.feature.friends.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.module.ServicePool.friendDetailService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FriendDetailViewModel : ViewModel() {

    private val _state: MutableStateFlow<FriendDetailState> =
        MutableStateFlow(FriendDetailState.Empty)
    val state: StateFlow<FriendDetailState> get() = _state

    private val _deleteState: MutableStateFlow<FriendDetailState> =
        MutableStateFlow(FriendDetailState.Empty)
    val deleteState: StateFlow<FriendDetailState> get() = _deleteState

    var artistMemberId: Long = 1

    fun postStar() {
        viewModelScope.launch {
            runCatching {
                friendDetailService.postStar(MEMBER_ID, artistMemberId)
            }
                .onSuccess {
                    _state.value = FriendDetailState.Success
                }
                .onFailure {
                    _state.value = FriendDetailState.Failure
                }
        }
    }

    fun deleteStar() {
        viewModelScope.launch {
            runCatching {
                friendDetailService.deleteStar(MEMBER_ID, artistMemberId)
            }
                .onSuccess {
                    _deleteState.value = FriendDetailState.Success
                }
                .onFailure {
                    _deleteState.value = FriendDetailState.Failure
                }
        }
    }

    companion object {
        private const val MEMBER_ID = "1"
    }
}