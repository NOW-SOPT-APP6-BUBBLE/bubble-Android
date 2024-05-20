package com.sopt.bubble.feature.more

import androidx.lifecycle.ViewModel
import com.sopt.bubble.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MoreViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MoreUiState())
    val uiState: StateFlow<MoreUiState> = _uiState.asStateFlow()

    companion object{
        const val TOP_BAR_RATIO = 360/62f

        val menuList = listOf<MoreMenu>(
            MoreMenu(
                iconResId = R.drawable.ic_more_my_bubble,
                textResId = R.string.more_btn_my_bubble,
                navigateRoute = ""
            ),
            MoreMenu(
                iconResId = R.drawable.ic_more_store,
                textResId = R.string.more_btn_store,
                navigateRoute = ""
            ),
            MoreMenu(
                iconResId = R.drawable.ic_more_notice,
                textResId = R.string.more_btn_notice,
                navigateRoute = ""
            ),
            MoreMenu(
                iconResId = R.drawable.ic_more_guide,
                textResId = R.string.more_btn_faq,
                navigateRoute = ""
            )
        )
    }
}