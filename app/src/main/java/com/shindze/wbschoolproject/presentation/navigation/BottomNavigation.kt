package com.shindze.wbschoolproject.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shindze.wbschoolproject.ui.theme.BodyOne
import com.shindze.wbschoolproject.ui.theme.WBFontFamily
import com.shindze.wbschoolproject.ui.theme.default
import com.shindze.wbschoolproject.ui.theme.offWhiteDisabled
import com.shindze.wbschoolproject.ui.theme.white

@Composable
fun BottomAppNavigation(innerNavController: NavHostController) {

    var selectedTab by remember { mutableStateOf(Screen.AllMeetings.route) }
    val currentBackStack by innerNavController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination

    BottomNavigation(
        backgroundColor = white, elevation = 0.dp
    ) {
        tabBarScreens.forEach { screen ->
            val isSelected =
                currentDestination?.hierarchy?.any { it.route == screen.route } == true || selectedTab == screen.route
            BottomNavigationItem(icon = {
                screen.icon?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        colorFilter = if (isSelected) ColorFilter.tint(default) else ColorFilter.tint(
                            offWhiteDisabled
                        )
                    )
                }
            }, label = {
                Text(
                    text = if (isSelected) screen.name else "",
                    fontFamily = WBFontFamily,
                    style = BodyOne,
                    color = default
                )
            }, selected = isSelected, onClick = {
                selectedTab = screen.route
                innerNavController.navigate(screen.route) {
                    popUpTo(innerNavController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            })
        }
    }
}