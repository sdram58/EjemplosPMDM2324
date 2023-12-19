package com.example.datastoreonboarding.navigation

sealed class Routes(val route:String){
    object SplashScreen: Routes("splash_screen")
    object Onboarding1Screen: Routes("onboarding_screen")
    object Onboarding2Screen: Routes("onboarding2_screen")
    object MainScreen: Routes("main_screen")
    object Onboarding1: Routes("second_screen/{name}"){
        fun createRoute(name:String) = "second_screen/$name"
    }
}