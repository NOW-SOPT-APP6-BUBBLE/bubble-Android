package com.sopt.bubble.feature.nav

sealed class Screen(
    val route: String,
) {
    object Test : Screen("test")
}