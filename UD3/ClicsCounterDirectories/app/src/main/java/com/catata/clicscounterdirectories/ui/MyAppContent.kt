package com.catata.clicscounterdirectories.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.catata.clicscounterdirectories.Content
import com.catata.clicscounterdirectories.ui.theme.ClicsCounterDirectoriesTheme

@Composable
fun MyAppContent(content:@Composable () -> Unit) {
    ClicsCounterDirectoriesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}