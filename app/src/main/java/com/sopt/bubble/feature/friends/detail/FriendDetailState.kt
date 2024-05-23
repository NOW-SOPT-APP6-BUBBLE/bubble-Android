package com.sopt.bubble.feature.friends.detail

sealed class FriendDetailState {
    data object Empty : FriendDetailState()
    data object Loading : FriendDetailState()
    data object Success : FriendDetailState()
}