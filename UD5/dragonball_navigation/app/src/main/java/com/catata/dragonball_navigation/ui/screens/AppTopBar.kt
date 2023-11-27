package com.catata.dragonball_navigation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.catata.p2dragonball.R

// Componente propio para la TopAppBar del Scaffold usado en la APP
//  Los comentarios son del primer diseño implementado para la TopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        title = {
//            Text(
//                text = "Dragon Ball",
//                fontSize = 30.sp
//            )
            Image(
                painter = painterResource(R.drawable.dragonball),
                contentDescription = "Dragon Ball Logo",
                modifier = Modifier.height(50.dp)
            )
        },
//        navigationIcon = {
//            Image(
//                painter = painterResource(R.drawable.fourstarball),
//                contentDescription = "Dragon Ball Logo",
//                modifier = Modifier.height(30.dp)
//            )
//        },
        actions = {
//            Image(
//                painter = painterResource(R.drawable.dragonball),
//                contentDescription = "Dragon Ball Logo",
//                modifier = Modifier.height(50.dp)
//            )
            Image(
                painter = painterResource(R.drawable.fourstarball),
                contentDescription = "Dragon Ball Logo",
                modifier = Modifier.height(30.dp)
            )
            Text(
                text = "by Akira Toriyama",
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}