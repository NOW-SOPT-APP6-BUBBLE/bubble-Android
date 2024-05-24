package com.sopt.bubble.feature.frienddetail

sealed class FriendDetailState {
    data object Empty : FriendDetailState()
    data object Loading : FriendDetailState()
    data object Success : FriendDetailState()
}