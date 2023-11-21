package com.example.navigation.ui.screens.first_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.navigation.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "First Screen")
            })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "App para navegar")

            var namState by rememberSaveable {
                mutableStateOf("")
            }

            TextField(
                value = namState,
                onValueChange = {namState = it},
                placeholder = { Text(text = "Introduce tu nombre")}
            )
            Button(onClick = {
                navController.navigate(route = Routes.Secondcreen.createRoute(namState))
                namState = ""
            },
                enabled = namState.isNotEmpty()
            ) {
                Text(text = "Navega a la segunda pantalla")
            }
        }
    }
}