package com.example.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.ui.screens.first_screen.FirstScreen
import com.example.navigation.ui.screens.second_screen.SecondScreen

@Composable
fun Navigation() {
    //Constante para gestionar el estado y se debe propagar entre todas las pantallas
    val navController = rememberNavController()

    //Elemento que conoce las diferentes pantallas y cual es la primera en lanzarse
    NavHost(
        navController = navController,
        startDestination = Routes.FirstScreen.route
    ){
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