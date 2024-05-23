package com.sopt.bubble.feature.friends.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.module.ServicePool.friendDetailService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FriendDetailViewModel : ViewModel() {

    private val _sideEffect: MutableStateFlow<FriendDetailState> =
        MutableStateFlow(FriendDetailState.Empty)
    val sideEffect: StateFlow<FriendDetailState> get() = _sideEffect.asStateFlow()

    var artistMemberId: Long = 1

    fun postStar() {
        viewModelScope.launch {
            runCatching {
                friendDetailService.postStar(MEMBER_ID, artistMemberId)
            }
                .onSuccess {
                    _sideEffect.emit(FriendDetailState.Success)
                }
                .onFailure {
                    _sideEffect.emit(FriendDetailState.Failure)
                }
        }
    }

    fun deleteStar() {

    }

    companion object {
        private const val MEMBER_ID = "1"
    }
}