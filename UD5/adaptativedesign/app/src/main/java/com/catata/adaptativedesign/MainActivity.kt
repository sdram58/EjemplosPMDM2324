package com.catata.adaptativedesign

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

import com.catata.adaptativedesign.navigation.Navigation
import com.catata.adaptativedesign.ui.AppContent


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            val heightSizeClass = calculateWindowSizeClass(this).heightSizeClass
            AppContent {
                Navigation()
            }
        }
    }

}
