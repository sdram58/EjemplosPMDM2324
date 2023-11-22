package com.catata.adaptativedesign.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.catata.adaptativedesign.ui.theme.AdaptativeDesignTheme

@Composable
fun AppContent(content: @Composable () -> Unit) {
    AdaptativeDesignTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()

        }
    }
}