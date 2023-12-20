package com.example.datastoreonboarding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.datastoreonboarding.ui.screens.SplashScreen
import com.example.datastoreonboarding.ui.screens.mainscreen.MainScreen
import com.example.datastoreonboarding.ui.screens.onboarding.OnBoarding1
import com.example.datastoreonboarding.ui.screens.onboarding.OnBoarding2
import com.example.datastoreonboarding.viewmodel.PreferencesViewModel

@Composable
fun Navigation(prefsViewModel: PreferencesViewModel) {
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
            SplashScreen(navController, prefsViewModel)
        }

        composable(
            route = Routes.Onboarding1Screen.route
        ){
            OnBoarding1(navController, prefsViewModel)
        }

        composable(
            route = Routes.Onboarding2Screen.route
        ){
            OnBoarding2(navController, prefsViewModel)
        }

        composable(
            route = Routes.MainScreen.route
        ){
            MainScreen(prefsViewModel)
        }


    }

}