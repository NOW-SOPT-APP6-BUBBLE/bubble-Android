package com.sopt.bubble.feature.nav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BubbleBottomNavigation(navHostController: NavHostController) {
    val items = listOf(
        Screen.Friends,
        Screen.Chat,
        Screen.More
    )

    BottomNavigation(
        backgroundColor = Color.White,
    ) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            BottomNavigationItem(
                icon = {
                    (if (isSelected) screen.selectedIcon else screen.icon)?.let {
                        painterResource(
                            id = it
                        )
                    }?.let {
                        Icon(
                            painter = it,
                            contentDescription = screen.resourceId.toString()
                        )
                    }
                },
                selected = isSelected,
                onClick = {
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}