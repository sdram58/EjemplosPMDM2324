package com.catata.dragonball_navigation.ui.screens

import android.content.res.Configuration
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import com.catata.dragonball_navigation.navigation.Navigation
import com.catata.dragonball_navigation.ui.screens.commons.AppTopBar
import com.catata.dragonball_navigation.ui.screens.commons.CharacterDetail
import com.catata.dragonball_navigation.ui.screens.commons.InfoDialog
import com.catata.dragonball_navigation.ui.screens.main_screen.DragonBallList
import com.catata.dragonball_navigation.ui.screens.main_screen.MainScreenLandscape
import com.catata.dragonball_navigation.ui.screens.main_screen.MainScreenPortrait
import com.catata.dragonball_navigation.ui.theme.DragonBallNavigationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(content: @Composable ()->Unit) {
    DragonBallNavigationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
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

                    content()

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