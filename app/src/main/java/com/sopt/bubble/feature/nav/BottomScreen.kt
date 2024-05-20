package com.sopt.bubble.feature.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.bubble.R

sealed class BottomScreen(
    val route: String,
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int,
    @StringRes val resourceId: Int,
) {
    object Friends : BottomScreen(
        "friends",
        R.drawable.ic_btn_friends,
        R.drawable.ic_btn_friends_true,
        R.string.screen_friends
    )

    object Chat :
        BottomScreen(
            "chat",
            R.drawable.ic_btn_chat,
            R.drawable.ic_btn_chat,
            R.string.screen_chat
        )

    object More :
        BottomScreen(
            "more",
            R.drawable.ic_btn_more,
            R.drawable.ic_btn_more_true,
            R.string.screen_more
        )
}