package com.catata.converterv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.catata.converterv2.ui.ConverterContent
import com.catata.converterv2.ui.screens.main.Converter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConverterContent {
                Converter()
            }
        }
    }
}