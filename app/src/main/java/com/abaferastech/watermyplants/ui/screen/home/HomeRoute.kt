package com.abaferastech.watermyplants.ui.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.addHomeRoute() {
    composable(
        route = "ROUTE",
    ) {
        ScreenHome()
    }
}

fun NavController.navigateToHome() {
    navigate("ROUTE")
}