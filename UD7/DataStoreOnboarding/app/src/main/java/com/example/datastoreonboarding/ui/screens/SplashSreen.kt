package com.example.datastoreonboarding.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.datastoreonboarding.R
import com.example.datastoreonboarding.navigation.Routes
import com.example.datastoreonboarding.viewmodel.PreferencesViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController:NavController, prefsViewModel: PreferencesViewModel) {
    LaunchedEffect(key1 = true){
        //Aquí deberíamos hacer la carga del sistema.
        //Consultar una BDD, acceder a una API, etc..
        //Lo simulamos con un delay de 5s
        delay(2000)
        //Lo quitamos de la pila por si el usuario le da a volver no vuelva al SplashScreen
        navController.popBackStack()

        //Comprobamos si hay algún dato guardado si lo hay vamos a la MainScreen
        if(prefsViewModel.load)


        navController.navigate(Routes.Onboarding1Screen.route)
    }

    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp,150.dp),
            contentScale = ContentScale.Fit


        )
        Text(text = "Bienvenidos",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )

    }
}