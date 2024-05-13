package com.sopt.bubble.feature.nav

import androidx.annotation.StringRes
import com.sopt.bubble.R

sealed class Screen(val route: String, val icon: Int, @StringRes val resourceId: Int) {
    object Friends : Screen("friends", R.drawable.ic_btn_friends, R.string.screen_friends)
    object Chat : Screen("chat", R.drawable.ic_btn_chat, R.string.screen_chat)
    object More : Screen("more", R.drawable.ic_btn_more, R.string.screen_more)
}