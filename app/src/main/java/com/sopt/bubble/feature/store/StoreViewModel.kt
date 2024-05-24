package com.sopt.bubble.feature.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.R
import com.sopt.bubble.module.ServicePool.storeService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StoreViewModel : ViewModel() {

    private val _state : MutableStateFlow<StoreState> = MutableStateFlow(StoreState.Empty)
    val state : StateFlow<StoreState> get () = _state

    private val _sideEffect: MutableSharedFlow<StoreSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<StoreSideEffect> = _sideEffect

    fun getArtistInfo() {
        viewModelScope.launch {
            runCatching {
                _state.value = StoreState.Loading
                storeService.getArtistListFromServer(MEMBER_ID)
            }
                .onSuccess {
                    _state.value = StoreState.Success(it.result.artists)
                    _sideEffect.emit(StoreSideEffect.Toast(R.string.server_success))
                }
                .onFailure {
                    _sideEffect.emit(StoreSideEffect.Toast(R.string.server_failure))
                }
        }
    }

    companion object {
        const val MEMBER_ID = "1"
    }

}