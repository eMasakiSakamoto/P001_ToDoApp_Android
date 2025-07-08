package com.free.masaki.sakamoto.todoapp.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.free.masaki.sakamoto.todoapp.R
import com.free.masaki.sakamoto.todoapp.navigation.HomeScreen

/**
 * ホーム画面のボトムバー
 *
 * @param items ボトムバーのアイテム
 * @param currentDestination 現在のナビゲーションの遷移先
 * @param onClickItem アイテムがクリックされた時の処理
 */
@Composable
fun HomeBottomBar(
    items: List<HomeBottomBarItem>,
    currentDestination: NavDestination?,
    onClickItem: (item: HomeBottomBarItem) -> Unit,
) {
    NavigationBar(
        modifier = Modifier
            .windowInsetsPadding(
                WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
            )
            .height(80.dp),
        containerColor = colorResource(R.color.bottom_bar_bg)
    ) {
        items.forEach { item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.screen.route } == true

            NavigationBarItem(
                selected = selected,
                onClick = { onClickItem(item) },
                icon = {
                    val icon = if (selected) {
                        item.selectedIcon
                    } else {
                        item.unselectedIcon
                    }
                    Icon(
                        painter = painterResource(icon),
                        modifier = Modifier.size(24.dp),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.iconText),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 4.dp),
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = colorResource(R.color.indicator),
                )
            )
        }
    }
}

/**
 * ホーム画面のボトムバーのアイテム
 *
 * @param selectedIcon 選択時のアイコン
 * @param unselectedIcon 費選択時のアイコン
 * @param title タイトル
 * @param iconText アイコンのテキスト
 * @param screen 遷移先の画面
 */
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
