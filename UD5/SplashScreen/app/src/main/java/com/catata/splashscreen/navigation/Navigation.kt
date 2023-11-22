package com.catata.splashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.catata.splashscreen.ui.screens.first_screen.FirstScreen
import com.catata.splashscreen.ui.screens.second_screen.SecondScreen
import com.catata.splashscreen.ui.screens.splash_screen.SplashScreen

@Composable
fun Navigation() {
    //Constante para gestionar el estado y se debe propagar entre todas las pantallas
    val navController = rememberNavController()

    //Elemento que conoce las diferentes pantallas y cual es la primera en lanzarse
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ){

        //Definición del SplashScreen
        composable(
            route = Routes.SplashScreen.route
        ){
            SplashScreen(navController)
        }
        //Definición de la primera pantalla
        composable(
            route = Routes.FirstScreen.route
        ){
            FirstScreen(navController)
        }

        //Definición pantalla que recibe un parámetro de tipo String
        composable(
            route = Routes.Secondcreen.route,
            arguments = listOf(
                navArgument(name = "name"){
                    type= NavType.StringType
                }
            )
        ){
            val argument = it.arguments?.getString("name")
            requireNotNull(argument)
            SecondScreen(navController, argument)
        }
    }

}