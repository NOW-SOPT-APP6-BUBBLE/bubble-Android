package com.sopt.bubble.feature.friends.detail

import androidx.annotation.StringRes

sealed class FriendDetailSideEffect {
    data class Toast(@StringRes val message: Int) : FriendDetailSideEffect()
}