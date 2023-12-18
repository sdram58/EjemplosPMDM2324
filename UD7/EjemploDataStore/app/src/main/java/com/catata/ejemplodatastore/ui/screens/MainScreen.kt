package com.catata.ejemplodatastore.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.catata.ejemplodatastore.User
import com.catata.ejemplodatastore.viewmodel.PreferencesViewModel

@Composable
fun MainScreen(preferencesViewModel: PreferencesViewModel) {

    val username by preferencesViewModel.username.observeAsState("")


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username,
            onValueChange = {
                preferencesViewModel.onUserNameChange(it)
            },
            label = { Text(text = "Nombre completo")}
        )

        Button(onClick = {
            preferencesViewModel.saveUser(User("a", "b", 1))
        }) {
            Text(text = "Guardar Nombre")
        }

        Button(onClick = {
            preferencesViewModel.loadFullName()
        }) {
            Text(text = "Recuperar Nombre")
        }
    }
}