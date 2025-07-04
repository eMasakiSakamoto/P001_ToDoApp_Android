package com.free.masaki.sakamoto.todoapp.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {

    Content(

    )
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {

        },
        bottomBar = {

        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding),
        ) {

        }

    }
}
