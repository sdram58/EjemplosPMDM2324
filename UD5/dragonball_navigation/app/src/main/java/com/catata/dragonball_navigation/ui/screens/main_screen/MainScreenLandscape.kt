package com.catata.dragonball_navigation.ui.screens.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.catata.dragonball_navigation.ui.screens.commons.AppTopBar
import com.catata.dragonball_navigation.ui.screens.commons.CharacterDetail
import com.catata.dragonball_navigation.ui.screens.commons.InfoDialog
import com.catata.dragonball_navigation.ui.theme.DragonBallNavigationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenLandscape() {
    DragonBallNavigationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Variable de estado para guardar el Character del que se está mostrando su información
            var characterId by rememberSaveable { mutableStateOf(-1) }
            // Variable de estado para poder llevar al inicio el scroll de la información del Character al seleccionar otro Character
            val scrollState = rememberLazyListState()
            // Variable de estado necesaria para poder mover el scroll en segundo plano
            val coroutineScope = rememberCoroutineScope()
            // La pantalla con los personajes se divide en dos: una lista de personajes y la información de un personaje
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                // Componente propio que mostrará la lista de personajes.
                //  Implementa State Hoisting para poder informar al componente de este archivo (DragonBallContent)
                //  del id del personaje sobre el que se pulse
                DragonBallList(
                    modifier = Modifier.weight(2.5f),
                    value = characterId,
                    onValueChange = {
                        characterId = it
                        // El código siguiente es necesario para mover al inicio el scroll de la información del personaje

                        coroutineScope.launch {
                            scrollState.animateScrollToItem(0, 0)
                        }
                    }
                )
                // Componente propio que mostrará la información del personaje seleccionado en la lista
                //  se le envía el id del personaje y también el la variable de estado para el scroll ya que el scroll se gestiona
                //  desde la lista de personajes (componente externo al LazyColumn que contiene este componente propio)
                CharacterDetail(
                    characterId = characterId,
                    scrollState = scrollState,
                    modifier = Modifier
                        .weight(7.5f)
                        .fillMaxHeight()
                )
            }
        }
    }
}
