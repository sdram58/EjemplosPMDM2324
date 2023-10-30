package com.catata.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.catata.profile.ui.ProfileContent
import com.catata.profile.ui.screens.profile.Profile


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileContent(){
                Profile()
            }
        }
    }
}
