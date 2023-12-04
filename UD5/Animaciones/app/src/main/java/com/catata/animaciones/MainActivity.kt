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
import androidx.compose.animation.togetherWith
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.style.TextAlign
import com.catata.animaciones.ui.theme.AnimacionesTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    /*var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )

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
    }*/

/*

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .verticalScroll(rememberScrollState())
    ) {

        var animateColor by rememberSaveable { mutableStateOf(false) }
        val backgroundColor by animateColorAsState(if (animateColor) Color(0xFFFFA020) else Color(0xFF40C0FF))
        Button(onClick = { animateColor = !animateColor }) {
            Text(text = "Cambiar color")
        }
        Text(
            text = "Hola Rick!",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(backgroundColor)
                .padding(20.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        var animateAlpha by rememberSaveable { mutableStateOf(true) }
        val alpha: Float by animateFloatAsState(if (animateAlpha) 1f else 0.3f)
        Button(onClick = { animateAlpha = !animateAlpha }) {
            Text(text = "Cambiar opacidad")
        }
        Box(
            modifier = Modifier
                .graphicsLayer(alpha = alpha)
                .fillMaxWidth()
                .background(Color(0xFFFFA020))
        ) {
            Text(
                text = "Hola Rick!",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(20.dp)

            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        var visible by rememberSaveable { mutableStateOf(false) }
        Button(onClick = {
            visible = !visible
        }) {
            Text(text = if (visible) "Ocultar" else "Mostrar")
        }
        AnimatedVisibility(visible = visible) {
            Text(
                text = "Hola Rick!",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color(0xFFFFA020))
                    .padding(20.dp)
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        var times by rememberSaveable { mutableStateOf(0) }
        Row {
            Button(onClick = { times++ }) {
                Text("+1")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { times-- }) {
                Text("-1")
            }

            AnimatedContent(targetState = times, label = "") {
                Text(
                    text = "Cuenta: $it",
                    modifier = Modifier.padding(10.dp)
                )
            }

            AnimatedContent(
                targetState = times,
                // Personalizando la animación
                transitionSpec = {
                    // targetState: nuevo valor de la variable de estado
                    // initialState: valor anterior de la variable de estado
                    if (targetState > initialState) {
                        (slideInVertically { height -> height } + fadeIn())
                            .togetherWith(slideOutVertically { height -> -height } + fadeOut())
                    } else {
                        (slideInVertically { height -> -height } + fadeIn())
                            .togetherWith(slideOutVertically { height -> height } + fadeOut())
                    }
                },
                label = ""
            ) { targetCount ->
                Text(
                    text = "$targetCount",
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))


        val sections = arrayOf("Anime", "Manga", "Otros")
        var visibleContent by rememberSaveable { mutableStateOf(sections[0]) }
        Row {
            for (section in sections) {
                Button(onClick = {
                    visibleContent = section
                }) {
                    Text(text = section)
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Crossfade(
            targetState = visibleContent,
            label = "",
        ) { screen ->
            when (screen) {
                "Manga" -> Text("Mostrar Manga")
                "Anime" -> Text("Mostrar Anime")
                "Otros" -> Text("Mostrar otros")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        var expanded by rememberSaveable { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Son goku")
                TextButton(onClick = { expanded = !expanded }) {
                    Text(if (expanded) "Menos." else "Leer más...")
                }
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Es el protagonista de la serie de manga y anime Dragon Ball." +
                            " Fue creado por Akira Toriyama en 1984. Al comienzo de la" +
                            " historia, Goku aparece como un niño que practica las artes" +
                            " marciales y que posee una cola de mono y una fuerza sobrehumana," +
                            " pero más adelante se revela que es un extraterrestre de la raza" +
                            " ficticia saiyajin, y que su nombre original es Kakarotto",
                    textAlign = TextAlign.Justify
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


    }*/

    
    var expanded by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Red)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Son goku")
            TextButton(onClick = { expanded = !expanded }) {
                Text(if (expanded) "Menos." else "Leer más...")
            }
        }
        if (expanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Es el protagonista de la serie de manga y anime Dragon Ball." +
                        " Fue creado por Akira Toriyama en 1984. Al comienzo de la" +
                        " historia, Goku aparece como un niño que practica las artes" +
                        " marciales y que posee una cola de mono y una fuerza sobrehumana," +
                        " pero más adelante se revela que es un extraterrestre de la raza" +
                        " ficticia saiyajin, y que su nombre original es Kakarotto",
                textAlign = TextAlign.Justify
            )
        }
    }

    
}


@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    AnimacionesTheme {
        Content()
    }
}