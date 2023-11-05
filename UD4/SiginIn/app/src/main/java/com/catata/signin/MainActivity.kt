package com.catata.signin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.catata.signin.ui.SignInContent
import com.catata.signin.ui.screens.signin.SignIn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                SignInContent {
                    SignIn()
                }
            }
        }
    }
}
