package com.sopt.bubble.feature.store

import androidx.annotation.StringRes

sealed class StoreSideEffect {
    data class Toast(@StringRes val message: Int) : StoreSideEffect()
}