package com.catata.splashscreen.ui.screens.splash_screen

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.catata.splashscreen.R
import com.catata.splashscreen.navigation.Routes
import com.catata.splashscreen.ui.theme.GreenSerra
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true){
        //Aquí deberíamos hacer la carga del sistema.
        //Consultar una BDD, acceder a una API, etc..
        //Lo simulamos con un delay de 5s
        delay(5000)
        //Lo quitamos de la pila por si el usuario le da a volver no vuelva al SplashScreen
        navController.popBackStack()
        navController.navigate(Routes.FirstScreen.route)
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
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp,150.dp),
            contentScale = ContentScale.Fit


        )
        Text(text = "Bienvenidos",
             fontSize = 30.sp,
             fontWeight = FontWeight.Bold,
             color = GreenSerra
        )

    }
}
