package com.catata.gestortareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.catata.gestortareas.navigation.Navigation
import com.catata.gestortareas.ui.theme.GestorTareasTheme
import com.catata.gestortareas.viewmodel.TaskViewModel
import androidx.compose.ui.Modifier


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val taskViewModel by viewModels<TaskViewModel>()


        setContent {
            GestorTareasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(taskViewModel)
                }
            }
        }
    }
}
