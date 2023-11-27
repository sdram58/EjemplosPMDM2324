package com.catata.dragonball_navigation.ui.screens.detail_screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import com.catata.dragonball_navigation.navigation.Routes
import com.catata.dragonball_navigation.ui.screens.commons.AppTopBar
import com.catata.dragonball_navigation.ui.screens.commons.CharacterDetail
import com.catata.dragonball_navigation.ui.screens.commons.InfoDialog
import com.catata.dragonball_navigation.ui.screens.main_screen.DragonBallList
import com.catata.dragonball_navigation.ui.screens.main_screen.MainScreenLandscape
import com.catata.dragonball_navigation.ui.screens.main_screen.MainScreenPortrait

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun DetailScreen(navController: NavController, characterId:Int) {
    // La pantalla con los personajes se divide en dos: una lista de personajes y la información de un personaje
    CharacterDetail(scrollState = rememberLazyListState(), characterId = characterId )

}