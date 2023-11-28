package com.catata.dragonball_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.catata.dragonball_navigation.navigation.Navigation
import com.catata.dragonball_navigation.ui.screens.AppContent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Al cargar la APP se cargará la única pantalla que tiene la APP
            Navigation()
        }
    }
}

