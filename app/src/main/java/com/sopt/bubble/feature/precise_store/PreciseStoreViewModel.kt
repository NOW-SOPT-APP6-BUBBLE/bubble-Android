package com.sopt.bubble.feature.precise_store

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.data.dto.response.ResponsePreciseArtistDto
import com.sopt.bubble.feature.precise_store.model.Ticket
import com.sopt.bubble.feature.precise_store.model.mockTicketList1
import com.sopt.bubble.module.ServicePool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PreciseStoreViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<PreciseStoreState>(PreciseStoreState.LoadingState)
    /*private val _uiState = MutableStateFlow<PreciseStoreState>(PreciseStoreState.SuccessState(
        artistInformation = ResponsePreciseArtistDto.Result.Artist(
            name =  "DAY6",
        description= "선물처럼 찾아오는 최애의 메시지와 함께하는 설레이는 일상!\n최애 아티스트와 나만의 특별한 프라이빗 메시지, bubble for JYPnation",
        photo = "https://github.com/NOW-SOPT-APP6-BUBBLE/bubble-Server/assets/109809242/a5df04be-a193-4bc6-8d0f-0085f9f7b190",
        subscribes = listOf(
            ResponsePreciseArtistDto.Result.Artist.Subscribe(
                name = "1인권",
                previousPrice = 4500,
                price = 4500
            ),
            ResponsePreciseArtistDto.Result.Artist.Subscribe(
                name = "2인권",
                previousPrice = 9000,
                price = 8000
            ),
        ),
            isServiceMembers= listOf(


    "WONPIL",
    "DOWOON"
            ),
    "isNotServiceMembers": [
    "SUNGJIN",
    "YOUNGK"
    ]
        )
    ))*/
    val uiState: StateFlow<PreciseStoreState> = _uiState.asStateFlow()

    fun getPreciseArtistInformation()  = viewModelScope.launch {
        runCatching {
            ServicePool.preciseStoreService.getPreciseArtistInformation(
                memberId = FIXED_MEMBER_ID,
                artistId = 1
            )
        }.onSuccess {
            val artist = it.result.artist
            _uiState.value = PreciseStoreState.SuccessState(
                artistInformation = artist
            )
            Log.d("PreciseStore", artist.toString())
        }.onFailure {

            Log.d("PreciseStoreError", "..")
        }
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

    private fun checkPurchasable(isCheckedList: List<Boolean>):Boolean = with(isCheckedList) {
        this[INDEX_CHECKBOX01] && this[INDEX_CHECKBOX02] && this[INDEX_CHECKBOX03]
    }

    companion object{
        const val INDEX_CHECKBOX01 = 0
        const val INDEX_CHECKBOX02 = 1
        const val INDEX_CHECKBOX03 = 2

        const val CHECK_BUTTON_NUM = 3

        const val FIXED_MEMBER_ID = "1"

        const val PRECISE_STORE_TOP_IMAGE_RATIO = 360 / 182f
        const val PRECISE_STORE_BANNER_IMAGE_RATIO = 320 / 64f
    }
}