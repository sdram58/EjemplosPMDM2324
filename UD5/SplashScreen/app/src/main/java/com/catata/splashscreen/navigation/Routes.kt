package com.catata.splashscreen.navigation


sealed class Routes(val route:String){
    object SplashScreen: Routes("splash_screen")
    object FirstScreen: Routes("first_screen")
    object Secondcreen: Routes("second_screen/{name}"){
        fun createRoute(name:String) = "second_screen/$name"
    }
}
