package com.sopt.bubble.feature.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.bubble.R

sealed class Screen(
    @StringRes val route: Int,
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int?,
    @StringRes val resourceId: Int,
) {
    object Friends : Screen(
        R.string.screen_friends_route,
        R.drawable.ic_btn_friends,
        R.drawable.ic_btn_friends_true,
        R.string.screen_friends
    )

    object Chat :
        Screen(
            R.string.screen_more_route,
            R.drawable.ic_btn_chat,
            R.drawable.ic_btn_chat,
            R.string.screen_chat
        )

    object More :
        Screen(
            R.string.screen_more_route,
            R.drawable.ic_btn_more,
            R.drawable.ic_btn_more_true,
            R.string.screen_more
        )
}