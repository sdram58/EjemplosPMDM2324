package com.catata.booksviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.catata.booksviewmodel.navigation.Navigation
import com.catata.booksviewmodel.ui.theme.BooksViewModelTheme
import com.catata.booksviewmodel.viewmodel.BookViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Si se necesita el ViewModel en una variable no puede declararse dentro de un componente @Composable
        val bookViewModel by viewModels<BookViewModel>()

        setContent {
            BooksViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(bookViewModel)
                    // Si solo se necesita el View Model en un lugar se puede declarar al llamar al componente
                    //Navigation(BookViewModel())
                }
            }
        }
    }
}
