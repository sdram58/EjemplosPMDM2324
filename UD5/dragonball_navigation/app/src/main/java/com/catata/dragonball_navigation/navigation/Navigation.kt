package com.catata.dragonball_navigation.navigation

import androidx.compose.runtime.Composable

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