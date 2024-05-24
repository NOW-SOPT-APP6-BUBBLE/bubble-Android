package com.sopt.bubble.feature.nav

sealed class Screen(
    val route: String,
) {
    data object Test : Screen("test")
    data object Detail : Screen("detail")
}