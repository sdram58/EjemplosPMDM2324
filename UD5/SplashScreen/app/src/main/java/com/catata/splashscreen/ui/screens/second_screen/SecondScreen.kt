package com.catata.splashscreen.ui.screens.second_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController, name:String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Second Screen")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        //Volvemos al elemento anterior en la pila de navegación
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Arrow Back"
                        )

                    }
                })
        }
    ) {
        var timesRemain by rememberSaveable {
            mutableStateOf(3)
        }
        BackHandler(enabled = timesRemain > 0, onBack = {
            timesRemain--
        })

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "He navegado")
            Text(text = "Parámetro; $name")
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text(text = "Volver atrás")
            }
        }

    }
}