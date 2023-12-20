package com.catata.gestortareas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.catata.gestortareas.ui.screens.MainScreen
import com.catata.gestortareas.ui.screens.SplashScreen
import com.catata.gestortareas.ui.screens.TaskInfo
import com.catata.gestortareas.viewmodel.TaskViewModel

@Composable
fun Navigation(taskViewModel: TaskViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route,
    ) {
        composable(Routes.SplashScreen.route) {
            SplashScreen(navController, taskViewModel)
        }

        composable(Routes.MainScreen.route) {
            MainScreen(navController, taskViewModel)
        }

        composable(Routes.TaskInfo.route) {
            TaskInfo(navController, taskViewModel)
        }
    }
}

