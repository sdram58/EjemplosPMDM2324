package com.catata.dragonball_navigation.ui.screens.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.catata.dragonball_navigation.R

// Componente propio para la TopAppBar del Scaffold usado en la APP
//  Los comentarios son del primer diseño implementado para la TopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(hasBackArrow:Boolean = false, title: (@Composable ()->Unit)?, onBackArrowClicked:(clicked:Boolean)->Unit) {
    TopAppBar(
        title = {
//            Text(
//                text = "Dragon Ball",
//                fontSize = 30.sp
//            )
            title?.let {
                title
            }?: run{
                Image(
                    painter = painterResource(R.drawable.dragonball),
                    contentDescription = "Dragon Ball Logo",
                    modifier = Modifier.height(50.dp)
                )
            }
        },
        navigationIcon = { if(hasBackArrow) {
            IconButton(onClick = {
                //Volvemos al elemento anterior en la pila de navegación
                onBackArrowClicked(true)
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back"
                )

            }
         }

        },
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