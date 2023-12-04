package com.catata.booksviewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.catata.booksviewmodel.viewmodel.BookViewModel
import com.catata.booksviewmodel.ui.screens.BookInfo
import com.catata.booksviewmodel.ui.screens.MainScreen

@Composable
fun Navigation(bookViewModel: BookViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen.route,
    ) {
        composable(Routes.MainScreen.route) {
            MainScreen(navController, bookViewModel)
        }

        composable(Routes.BookInfo.route) {
            BookInfo(navController, bookViewModel)
        }
    }
}

