package com.sopt.bubble.presentation.more

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MoreUiState(
    val nickName: String = "언니",
    val email: String = "612240@naver.com"
)
class MoreViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MoreUiState())
    val uiState: StateFlow<MoreUiState> = _uiState.asStateFlow()


    companion object{
        const val TOP_BAR_RATIO = 360/62f
    }
}