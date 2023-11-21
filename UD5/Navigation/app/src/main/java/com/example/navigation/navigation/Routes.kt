package com.example.navigation.navigation

sealed class Routes(val route:String){
    object FirstScreen: Routes("first_screen")
    object Secondcreen: Routes("second_screen/{name}"){
        fun createRoute(name:String) = "second_screen/$name"
    }
}