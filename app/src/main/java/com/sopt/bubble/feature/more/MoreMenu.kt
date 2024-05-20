package com.sopt.bubble.feature.more

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MoreMenu(
    @StringRes
    val textResId: Int,
    @DrawableRes
    val iconResId: Int,
    val navigateRoute: String
)


