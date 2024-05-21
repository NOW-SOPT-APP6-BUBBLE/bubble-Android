package com.sopt.bubble.feature.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.module.ServicePool.storeService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class StoreViewModel : ViewModel() {

    private val _sideEffect: MutableSharedFlow<StoreSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<StoreSideEffect> get() = _sideEffect

    fun getArtistInfo() {
        viewModelScope.launch {
            runCatching {
                storeService.getArtistListFromServer(MEMBER_ID)
            }
                .onSuccess {
                    _sideEffect.emit(StoreSideEffect.Success(it.result.artists))
                }
                .onFailure {
                    _sideEffect.emit(StoreSideEffect.Failure)
                }
        }
    }

    companion object {
        const val MEMBER_ID = "1"
    }

}