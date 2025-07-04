package com.free.masaki.sakamoto.todoapp.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import com.free.masaki.sakamoto.todoapp.R
import com.free.masaki.sakamoto.todoapp.navigation.HomeScreen

@Composable
fun HomeBottomBar(
    items: List<HomeBottomBarItem>,
    currentDestination: NavDestination?,
    onClickItem: (item: HomeBottomBarItem) -> Unit,
) {
    NavigationBar(
        modifier = Modifier,
    ) {

    }
}

sealed class HomeBottomBarItem(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val title: Int,
    @StringRes val iconText: Int,
    val screen: HomeScreen,
) {

    /** タスク */
    data object Todo : HomeBottomBarItem(
        selectedIcon = R.drawable.ic_todo,
        unselectedIcon = R.drawable.ic_todo,
        title = R.string.todo,
        iconText = R.string.todo,
        screen = HomeScreen.Todo,
    )

    /** 完了済 */
    data object Complete : HomeBottomBarItem(
        selectedIcon = R.drawable.ic_complete_on,
        unselectedIcon = R.drawable.ic_complete,
        title = R.string.complete,
        iconText = R.string.complete,
        screen = HomeScreen.Complete,
    )

    /** アプリ */
    data object App : HomeBottomBarItem(
        selectedIcon = R.drawable.ic_app,
        unselectedIcon = R.drawable.ic_app,
        title = R.string.app,
        iconText = R.string.app,
        screen = HomeScreen.App,
    )

    /** 設定 */
    data object Settings : HomeBottomBarItem(
        selectedIcon = R.drawable.ic_setting_on,
        unselectedIcon = R.drawable.ic_setting,
        title = R.string.settings,
        iconText = R.string.settings,
        screen = HomeScreen.Settings,
    )
}
