package com.sopt.bubble.feature.friends.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.module.ServicePool.friendDetailService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class FriendDetailViewModel : ViewModel() {

    private val _sideEffect: MutableSharedFlow<FriendDetailSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<FriendDetailSideEffect> get() = _sideEffect

    fun postStar() {
        viewModelScope.launch {
            runCatching {
                friendDetailService.postStar("1", 1)
            }
                .onSuccess {
                    _sideEffect.emit(FriendDetailSideEffect.Success)
                }
                .onFailure {
                    _sideEffect.emit(FriendDetailSideEffect.Failure)
                }
        }
    }

    fun deleteStar() {

    }
}