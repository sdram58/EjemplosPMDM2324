package com.catata.booksviewmodel.navigation

sealed class Routes(val route: String) {
    object MainScreen: Routes("main_screen")
    object BookInfo: Routes("book_info_screen")
}


