package com.sopt.bubble.feature.nav

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 16.dp ,
                shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)
            ),
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