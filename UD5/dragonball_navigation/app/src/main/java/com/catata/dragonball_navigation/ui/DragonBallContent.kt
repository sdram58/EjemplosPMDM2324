package com.catata.dragonball_navigation.ui

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
import com.catata.dragonball_navigation.ui.screens.AppTopBar
import com.catata.dragonball_navigation.ui.screens.CharacterDetail
import com.catata.dragonball_navigation.ui.screens.DragonBallList
import com.catata.dragonball_navigation.ui.screens.InfoDialog
import com.catata.dragonball_navigation.ui.theme.DragonBallNavigationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DragonBallContent() {
    DragonBallNavigationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Variable de estado para guardar el Character del que se está mostrando su información
            var characterId by rememberSaveable { mutableStateOf(0) }
            // Variable de estado para poder llevar al inicio el scroll de la información del Character al seleccionar otro Character
            val scrollState = rememberLazyListState()
            // Variable de estado necesaria para poder mover el scroll en segundo plano
            val coroutineScope = rememberCoroutineScope()
            // Variable de estado para indicar si se debe mostrar la información del autor de la APP o no
            var viewAuthor by rememberSaveable { mutableStateOf(false) }

            Scaffold(
                // Toda la TopBar se ha movido a un componente propio
                topBar = { AppTopBar() },
                floatingActionButton = {
                    // El botón solo se mostrará si la variable de estado viewAuthor es false
                    if (!viewAuthor) {
                        FloatingActionButton(onClick = { viewAuthor = !viewAuthor }) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Autor"
                            )
                        }
                    }
                },
                floatingActionButtonPosition = FabPosition.End
            ) {
                // El contenido de la pantalla se mostrará en un Box para poder situar encima de toda la información del autor de la APP
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
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

                    // Dependiendo del valor de viewAuthor se mostrará o no un Box con la información del autor de la APP
                    if (viewAuthor) {
                        Box(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = .5f))
                                .fillMaxSize()
                                .clickable { viewAuthor = !viewAuthor },
                            contentAlignment = Alignment.Center
                        ) {
                            InfoDialog()
                        }
                    }
                }
            }
        }
    }
}
