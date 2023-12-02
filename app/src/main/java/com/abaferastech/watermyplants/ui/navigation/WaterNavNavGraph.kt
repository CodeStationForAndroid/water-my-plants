package com.abaferastech.watermyplants.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abaferastech.watermyplants.ui.screen.addscreen.AddScreen
import com.abaferastech.watermyplants.ui.screen.addscreen.camera.Camera
import com.abaferastech.watermyplants.ui.screen.detailscreen.DetailScreen
import com.abaferastech.watermyplants.ui.screen.home.HomeScreen

@Composable
fun WaterNavNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screens.AddScreen.route){
            AddScreen(navController = navController)
        }
        composable(route = Screens.CameraScreen.route){
            Camera(navController = navController)
        }
        composable(route = Screens.DetailScreen.route + "?plantId={plantId}",
            arguments = listOf(
                navArgument(
                    name = "plantId"
                ){
                    type = NavType.IntType
                    defaultValue = -1
                }
            )

            ){
            DetailScreen(navController = navController)
        }

    }
}