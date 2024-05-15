package com.sopt.bubble.presentation.precise_store

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sopt.bubble.R
import com.sopt.bubble.presentation.precise_store.model.Ticket
import com.sopt.bubble.presentation.precise_store.model.mockTicketList1
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber

data class PreciseStoreState(
    val isCheckedList: List<Boolean> = listOf(false, false, false),
    val isMore: Boolean = false,
    val isPurchasable: Boolean = false,

    val artistName: String = "DAY6",
    val bubbleDescription:String = "선물처럼 찾아오는 최애의 메시지와 함께하는 설레이는 일상!\n" +
            "최애 아티스트와 나만의 특별한 프라이빗 메시지, bubble for JYPnation",
    val artistLineup: String = "WONPIL, DOWOON",
    val artistComingSoon: String? = "SUNGJIN, Young K",

    val bubbleIntroduction: String = "bubble for JYPnation DAY6는 DAY6 팬들을 위한 특별한 서비스입니다.\n" +
"\n" +
"나만의 최애 DAY6 멤버가 직접 작성하는 개성 넘치는 프라이빗한 메시지를 받을 수 있습니다.\n" +
"\n" +
"bubble for JYPnation은 아티스트의 창작활동을 지원하고 응원합니다.",
    val ticketList: List<Ticket> = listOf()
)

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

        const val PRECISE_STORE_TOP_IMAGE_RATIO = 360 / 182f
        const val PRECISE_STORE_BANNER_IMAGE_RATIO = 320 / 64f
    }
}