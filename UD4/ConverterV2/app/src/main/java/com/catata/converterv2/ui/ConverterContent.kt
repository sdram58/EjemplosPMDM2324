package com.catata.converterv2.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.catata.converterv2.ui.theme.ConverterV2Theme

@Composable
fun ConverterContent(content: @Composable () -> Unit) {
    ConverterV2Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}