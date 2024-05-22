package com.sopt.bubble.feature.friends.detail

sealed class FriendDetailSideEffect {
    data object Success : FriendDetailSideEffect()

    data object Failure : FriendDetailSideEffect()
}