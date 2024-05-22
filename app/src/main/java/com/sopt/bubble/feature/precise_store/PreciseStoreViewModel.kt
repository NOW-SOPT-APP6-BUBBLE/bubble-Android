package com.sopt.bubble.feature.precise_store

import androidx.lifecycle.ViewModel
import com.sopt.bubble.feature.precise_store.model.Ticket
import com.sopt.bubble.feature.precise_store.model.mockTicketList1
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PreciseStoreViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PreciseStoreState(ticketList = mockTicketList1))
    val uiState: StateFlow<PreciseStoreState> = _uiState.asStateFlow()

    fun onClickMore() {
        _uiState.update { currentState->
            currentState.copy(
                isMore = !currentState.isMore
            )
        }
    }

    fun onClickCheckBox(index: Int) {
        _uiState.update {currentState ->
            val currentCheckedList = currentState.isCheckedList.toMutableList()
            currentCheckedList[index] = !currentCheckedList[index]

            currentState.copy(
                isCheckedList = currentCheckedList.toList(),
                isPurchasable = checkPurchasable(currentCheckedList)
            )
        }
    }

    private fun checkPurchasable(isCheckedList: List<Boolean>):Boolean = with(isCheckedList) {
        this[INDEX_CHECKBOX01] && this[INDEX_CHECKBOX02] && this[INDEX_CHECKBOX03]
    }

    companion object{
        const val INDEX_CHECKBOX01 = 0
        const val INDEX_CHECKBOX02 = 1
        const val INDEX_CHECKBOX03 = 2

        const val CHECK_BUTTON_NUM = 3

        const val PRECISE_STORE_TOP_IMAGE_RATIO = 360 / 182f
        const val PRECISE_STORE_BANNER_IMAGE_RATIO = 320 / 64f
    }
}