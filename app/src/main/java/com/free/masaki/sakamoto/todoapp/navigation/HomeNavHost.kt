package com.free.masaki.sakamoto.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.free.masaki.sakamoto.todoapp.presentation.screen.app.AppScreen
import com.free.masaki.sakamoto.todoapp.presentation.screen.complete.CompleteScreen
import com.free.masaki.sakamoto.todoapp.presentation.screen.settings.SettingsScreen
import com.free.masaki.sakamoto.todoapp.presentation.screen.todo.TodoScreen

@Composable
fun HomeNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(route = HomeScreen.Todo.route) {
            TodoScreen()
        }
        composable(route = HomeScreen.Complete.route) {
            CompleteScreen()
        }
        composable(route = HomeScreen.App.route) {
            AppScreen()
        }
        composable(route = HomeScreen.Settings.route) {
            SettingsScreen()
        }
    }
}