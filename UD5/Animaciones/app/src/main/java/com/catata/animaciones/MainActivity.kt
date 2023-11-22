package com.catata.animaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.style.TextAlign
import com.catata.animaciones.ui.theme.AnimacionesTheme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimacionesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            /*.animateContentSize(animationSpec = tween(
                durationMillis = 2000,
                easing = LinearEasing
            ))*/
            .background(Color(0xFFFFA0C0))
            //.padding(10.dp)

    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Son Goku")
            TextButton(onClick = {
                expanded = !expanded
            }) {
                Text(text = if(expanded) "Menos." else "Leer más...")
            }
        }

        Text(text = "Hey!")
        if(expanded){
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Goku niño: Un pequeño con cola tiene una habilidad innata para convertirse"+
                    "en un mono gigante sin capacidad de razonamiento y que destroza todo lo que "+
                    "esté a su paso. Sus principales enemigos derrotados fueron Pilaf, los soldados"+
                    " del Ejército Rojo y el tradicional Piccolo Daimao.\n" +
                    "\n" +
                    "Goku joven: Milk, una doncella heredera al trono de un pueblo pequeño, se casa"+
                    " con Goku y tienen juntos a su primer hijo, Gohan. Sin embargo, después de "+
                    "algunos años, su hermano Raditz llega a la Tierra con la única misión de "+
                    "colonizarla por completo y un equipo de guerreros se une para detenerlo. Goku "+
                    "pierde la vida por primera vez y conoce el Reino de los Cielos.\n" +
                    "\n"+
                 "Goku adulto: Tal vez el momento más importante en la historia del alienígena. "+
                    "En poco más de 10 diez años, Goku adquiere el superpoder de transformarse en "+
                    "Super Saiyajin 1, Super Saiyajin 2, Super Saiyajin 3 y las fases de Dios.\n" +
                    "\n" +
                    "Después de la llegada del Dios de la destrucción, Beerus, los rituales de "+
                    "transformación de Kakaroto superan lo místico hasta alcanzar un poder a la "+
                    "altura del mismo creador de todo el universo.",
                 textAlign = TextAlign.Justify)
        }
    }

    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimacionesTheme {
        Greeting("Android")
    }
}