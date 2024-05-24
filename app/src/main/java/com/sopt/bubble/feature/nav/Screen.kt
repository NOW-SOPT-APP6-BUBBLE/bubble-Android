package com.sopt.bubble.feature.nav

sealed class Screen(
    val route: String,
) {
    data object Store : Screen("store")
    data object Detail : Screen("detail")
    data object Precise : Screen("precise")
}