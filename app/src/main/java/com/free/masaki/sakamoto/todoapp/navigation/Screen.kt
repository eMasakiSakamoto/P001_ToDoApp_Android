package com.free.masaki.sakamoto.todoapp.navigation

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home_screen")
}

sealed class HomeScreen(val route: String) {
    data object Todo : HomeScreen(route = "todo_screen")
    data object Complete : HomeScreen(route = "complete_screen")
    data object App : HomeScreen(route = "app_screen")
    data object Settings : HomeScreen(route = "settings_screen")
}
