package com.catata.gestortareas.navigation

sealed class Routes(val route: String) {
    object SplashScreen: Routes("splash_screen")
    object MainScreen: Routes("main_screen")
    object TaskInfo: Routes("task_info_screen")
}


