package com.catata.dragonball_navigation.navigation

import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.catata.dragonball_navigation.ui.screens.AppContent
import com.catata.dragonball_navigation.ui.screens.AppContentData
import com.catata.dragonball_navigation.ui.screens.detail_screen.DetailScreen
import com.catata.dragonball_navigation.ui.screens.main_screen.MainScreenLandscape
import com.catata.dragonball_navigation.ui.screens.main_screen.MainScreenPortrait
import com.catata.dragonball_navigation.ui.screens.splash_screen.SplashScreen


@Composable
fun Navigation() {

    //Constante para gestionar el estado y se debe propagar entre todas las pantallas
    val navController = rememberNavController()

    //Elemento que conoce las diferentes pantallas y cual es la primera en lanzarse
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ){

        //Definición de la primera pantalla
        composable(
            route = Routes.SplashScreen.route
        ){
            SplashScreen(navController)
        }

        //Definición de la primera pantalla
        composable(
            route = Routes.MainScreen.route
        ){
            if(LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT){
                /*Vertical*/
                AppContent(
                    AppContentData(
                        navController = navController,
                        shouldAppear = true,
                        title = null) {
                            MainScreenPortrait(navController = navController)
                        }
                )

            }else {
                /*Horizontal*/
                AppContent(
                    AppContentData(
                        navController = navController,
                        shouldAppear = true,
                        title = null){
                            MainScreenLandscape()
                        }
                )
            }
        }

        //Definición pantalla que recibe un parámetro de tipo String
        composable(
            route = Routes.DetailScreen.route,
            arguments = listOf(
                navArgument(name = "id"){
                    type= NavType.IntType
                }
            )
        ){
            val argument = it.arguments?.getInt("id")
            requireNotNull(argument)
            if(LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT){
                /*Vertical*/
                AppContent(
                    AppContentData(
                        navController = navController,
                        shouldAppear = true,
                        hasBackArrow = true,
                        title = null){
                            DetailScreen(navController, argument)
                    }
                )

            }else {
                /*Horizontal*/
                AppContent(
                    AppContentData(
                        navController = navController,
                        shouldAppear = true,
                        title = null){
                            MainScreenLandscape()
                        }
                )

            }

        }
    }

}