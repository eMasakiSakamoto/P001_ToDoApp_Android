package com.free.masaki.sakamoto.todoapp.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.free.masaki.sakamoto.todoapp.presentation.components.HomeBottomBar
import com.free.masaki.sakamoto.todoapp.presentation.components.HomeBottomBarItem

@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Content(
        navController = navController,
        bottomBarItems = listOf(
            HomeBottomBarItem.Todo,
            HomeBottomBarItem.Complete,
            HomeBottomBarItem.App,
            HomeBottomBarItem.Settings,
        )
    )
}

@Composable
private fun Content(
    navController: NavHostController,
    bottomBarItems: List<HomeBottomBarItem>,
    modifier: Modifier = Modifier,
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    Scaffold(
        modifier = modifier,
        topBar = {

        },
        bottomBar = {
            HomeBottomBar(
                items = bottomBarItems,
                currentDestination = currentDestination,
                onClickItem = {},
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding),
        ) {

        }
    }
}
