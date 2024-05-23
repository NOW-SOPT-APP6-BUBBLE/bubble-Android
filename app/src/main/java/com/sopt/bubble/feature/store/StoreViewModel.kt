package com.sopt.bubble.feature.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.module.ServicePool.storeService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class StoreViewModel : ViewModel() {

    private val _sideEffect: MutableSharedFlow<StoreState> = MutableSharedFlow()
    val sideEffect: SharedFlow<StoreState> get() = _sideEffect

    fun getArtistInfo() {
        viewModelScope.launch {
            runCatching {
                storeService.getArtistListFromServer(MEMBER_ID)
            }
                .onSuccess {
                    _sideEffect.emit(StoreState.Success(it.result.artists))
                }
                .onFailure {
                    _sideEffect.emit(StoreState.Failure)
                }
        }
    }

    companion object {
        const val MEMBER_ID = "1"
    }

}