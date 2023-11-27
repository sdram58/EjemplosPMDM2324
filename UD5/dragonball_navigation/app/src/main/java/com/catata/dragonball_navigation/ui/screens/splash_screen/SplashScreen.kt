package com.catata.dragonball_navigation.ui.screens.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.catata.dragonball_navigation.R
import com.catata.dragonball_navigation.navigation.Routes
import com.catata.dragonball_navigation.ui.theme.BackgroundColorSplash
import com.catata.dragonball_navigation.ui.theme.DragonBall
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true){
        //Aquí deberíamos hacer la carga del sistema.
        //Consultar una BDD, acceder a una API, etc..
        //Lo simulamos con un delay de 5s
        delay(3000)
        //Lo quitamos de la pila por si el usuario le da a volver no vuelva al SplashScreen
        navController.popBackStack()
        navController.navigate(Routes.MainScreen.route)
    }

    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColorSplash),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fourstarball),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp,150.dp),
            contentScale = ContentScale.Fit


        )
        Text(text = stringResource(id = R.string.dragon_ball),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = DragonBall
        )

    }
}