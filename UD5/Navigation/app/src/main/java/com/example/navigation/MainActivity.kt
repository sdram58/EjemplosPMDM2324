package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.navigation.navigation.Navigation
import com.example.navigation.ui.AppContent

@OptIn(ExperimentalMaterial3WindowsSizeClassApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent {
                val widthSizeClass = calculateWindowsSizeClass(this)
                Navigation()
            }
        }
    }
}
