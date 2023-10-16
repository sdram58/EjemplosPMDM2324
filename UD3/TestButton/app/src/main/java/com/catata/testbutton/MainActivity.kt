package com.catata.testbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.catata.testbutton.ui.theme.TestButtonTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyColumn()
                }
            }
        }
    }
}

@Composable
fun MyColumn(){
    val a = Random.nextInt()
    Column(
        modifier = Modifier
            .background(color= Color.Cyan)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        if(a%2==0)
            MyButton("Par", a%2==0)
        else
            MyButton("Impar")
    }
}

@Composable
fun MyButton(text:String, enabled:Boolean = false) {
    Button(
        colors = ButtonDefaults.buttonColors(
            contentColor= Color.Red,
            containerColor= Color.Black,
            disabledContainerColor= Color(0xFF00CCCC),
            disabledContentColor= Color(0xFF00FF00)
        ),
        onClick = {

        },
        enabled = enabled

    ) {
        Text(text = text)
    }
}


@Preview(showBackground = true, name="Android Greeting")
@Composable
fun MyColumnPreview() {
    TestButtonTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyColumn()
        }
    }
}
