package com.catata.temas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import com.catata.temas.ui.theme.TemasTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemasTheme {
               val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color(0xFF0080FF),
                        darkIcons = true
                    )

                    systemUiController.isStatusBarVisible = false

                    systemUiController.setNavigationBarColor(
                        color = Color(0xFF00FF80),
                        darkIcons = true
                    )
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    Text(
        text = "Hola Rick!",
        style = MaterialTheme.typography.bodyLarge.copy(
            shadow = Shadow(
                offset = Offset(5f,5f),
                blurRadius = 2f,
                color = Color(0xFFFF8000)
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TemasTheme {
        Greeting()
    }
}