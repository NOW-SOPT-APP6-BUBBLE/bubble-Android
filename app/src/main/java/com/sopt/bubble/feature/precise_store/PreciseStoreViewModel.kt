package com.sopt.bubble.feature.precise_store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.module.ServicePool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PreciseStoreViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<PreciseStoreState>(PreciseStoreState.LoadingState)
    val uiState: StateFlow<PreciseStoreState> = _uiState.asStateFlow()

    fun getPreciseArtistInformation(artistId: Long) = viewModelScope.launch {
        runCatching {
            ServicePool.preciseStoreService.getPreciseArtistInformation(
                memberId = FIXED_MEMBER_ID,
                artistId = artistId
            )
        }.onSuccess {
            with(it.result.artist) {
                _uiState.value = PreciseStoreState.SuccessState(
                    name = this.name,
                    description = this.description,
                    photo = this.photo,
                    subscribes = this.subscribes,
                    isServiceMember = this.isServiceMember.toString().substring(
                        startIndex = 1,
                        endIndex = this.isServiceMember.toString().length - 1
                    ),
                    isNotServiceMember = this.isNotServiceMember.toString().substring(
                        startIndex = 1,
                        endIndex = this.isNotServiceMember.toString().length - 1
                    )
                )
            }
        }.onFailure {}
    }

    fun onClickCheckBox(index: Int) {
        _uiState.update {
            val currentState = it as PreciseStoreState.SuccessState
            val currentCheckedList = currentState.isCheckedList.toMutableList()
            currentCheckedList[index] = !currentCheckedList[index]

            currentState.copy(
                isCheckedList = currentCheckedList.toList(),
                isPurchasable = checkPurchasable(currentCheckedList)
            )
        }
    }

    private fun checkPurchasable(isCheckedList: List<Boolean>): Boolean = with(isCheckedList) {
        this[INDEX_CHECKBOX01] && this[INDEX_CHECKBOX02] && this[INDEX_CHECKBOX03]
    }

    companion object {
        const val INDEX_CHECKBOX01 = 0
        const val INDEX_CHECKBOX02 = 1
        const val INDEX_CHECKBOX03 = 2

        const val CHECK_BUTTON_NUM = 3

        const val FIXED_MEMBER_ID = "1"

        const val PRECISE_STORE_TOP_IMAGE_RATIO = 360 / 182f
        const val PRECISE_STORE_BANNER_IMAGE_RATIO = 320 / 64f
    }
}