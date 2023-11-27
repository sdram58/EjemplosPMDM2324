package com.catata.dragonball_navigation.ui.screens.main_screen

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    //Dentro de un elemento composable
    if(LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT){
        /*Vertical*/
        MainScreenPortrait(navController)
    }else{
        /*Horizontal*/
        MainScreenLandscape()
    }
}