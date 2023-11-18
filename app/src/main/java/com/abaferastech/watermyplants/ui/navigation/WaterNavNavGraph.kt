package com.abaferastech.watermyplants.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

@Composable
fun WaterNavNavGraph() {
    NavHost(
        navController = LocalNavController.current,
        startDestination = "/*TODO add destination*/"
    ) {

    }
}