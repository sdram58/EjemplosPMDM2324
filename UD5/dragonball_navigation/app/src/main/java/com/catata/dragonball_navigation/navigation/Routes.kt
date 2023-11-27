package com.catata.dragonball_navigation.navigation

sealed class Routes(val route:String) {
    object SplashScreen: Routes("splash_screen")
    object MainScreen: Routes("main_screen")
    object DetailScreen: Routes("detail_screen/{id}"){
        fun createRoute(id:Int) = "detail_screen/$id"
    }
}