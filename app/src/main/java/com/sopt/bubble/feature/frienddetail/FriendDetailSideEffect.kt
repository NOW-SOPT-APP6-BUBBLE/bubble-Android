package com.sopt.bubble.feature.frienddetail

import androidx.annotation.StringRes

sealed class FriendDetailSideEffect {
    data class Toast(@StringRes val message: Int) : FriendDetailSideEffect()
}