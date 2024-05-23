package com.sopt.bubble.feature.friends

import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bubble.data.dto.Artist
import com.sopt.bubble.module.ServicePool.friendService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FriendsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<FriendState>(FriendState.Loading)
    val uiState: StateFlow<FriendState> = _uiState.asStateFlow()

    private val _subsArtistList = MutableStateFlow<List<Artist>>(emptyList())
    val subsArtistList: StateFlow<List<Artist>> = _subsArtistList.asStateFlow()

    private val _notSubsArtistList = MutableStateFlow<List<Artist>>(emptyList())
    val notSubsArtistList: StateFlow<List<Artist>> = _notSubsArtistList.asStateFlow()


    fun getFriends() {
        viewModelScope.launch {
            runCatching {
                friendService.getFriends(MEMBER_ID)
            }
                .onSuccess {
                    _uiState.emit(
                        FriendState.Success(
                            it.result.isSubsArtists,
                            it.result.isNotSubsArtists
                        )
                    )
                    _subsArtistList.value = it.result.isSubsArtists
                    _notSubsArtistList.value = it.result.isNotSubsArtists
                }
                .onFailure {
                    _uiState.emit(FriendState.Failure)
                }
        }
    }



    companion object FriendsComponentConstants {
        const val TOP_BAR_RATIO = 360 / 62f
        val COLLAPSED_TOP_BAR_HEIGHT = 56.dp
        val EXPANDED_TOP_BAR_HEIGHT = 200.dp
        const val ENTER_EXPAND_FROM_TOP_INITIAL_HEIGHT = 20
        const val EXIT_SHRINK_DIVISOR = 2
        const val MEMBER_ID = "1"
    }
}