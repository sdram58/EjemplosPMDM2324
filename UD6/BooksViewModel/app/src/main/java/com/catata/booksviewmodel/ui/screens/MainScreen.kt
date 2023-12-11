@file:OptIn(ExperimentalMaterial3Api::class)

package com.catata.booksviewmodel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.catata.booksviewmodel.model.Book
import com.catata.booksviewmodel.navigation.Routes
import com.catata.booksviewmodel.ui.common.AuthorInfo
import com.catata.booksviewmodel.viewmodel.BookViewModel



@Composable
fun MainScreen(
    navController: NavHostController,
    bookViewModel: BookViewModel
) {
    val books: List<Book> by bookViewModel.books.observeAsState(initial = emptyList())
    val isLoadingBooks: Boolean by bookViewModel.isLoading.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        SearchField(
            bookViewModel = bookViewModel,
            modifier = Modifier.weight(1f)
        )

        Divider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.onPrimary,
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(vertical = 8.dp)
                .weight(7.7f)
        ) {
            items(books) { book ->
                if (book.visible) {
                    BookCard(
                        book = book,
                        navController = navController,
                        bookViewModel = bookViewModel
                    )
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(.3f)
        ) {
            Text(
                text = "Recarga la lista de libros",
                color = MaterialTheme.colorScheme.onPrimary
            )
            IconButton(onClick = {
                bookViewModel.loadBookList()
            }) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Recargar",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        AuthorInfo(modifier = Modifier.weight(1f))

        if (isLoadingBooks) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Loading...",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(20.dp))
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    bookViewModel: BookViewModel,
    modifier: Modifier = Modifier
) {
    var searchString by rememberSaveable { mutableStateOf("") }
    val deleteSearchEnabled by remember {
        derivedStateOf {
            searchString.isNotEmpty()
        }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TextField(
            value = searchString,
            onValueChange = {
                if (searchString.length > it.length) {
                    bookViewModel.resetSearchList()
                }

                if (it.isNotEmpty()) {
                    bookViewModel.searchBook(it)
                }
                searchString = it
            },
            label = { Text(text = "Buscar libro") },
            trailingIcon = {
                if (deleteSearchEnabled) {
                    IconButton(onClick = {
                        searchString = ""
                        bookViewModel.resetSearchList()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Cancel,
                            contentDescription = "Cancelar búsqueda"
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BookCard(
    book: Book,
    navController: NavHostController,
    bookViewModel: BookViewModel
) {
    OutlinedCard(
        modifier = Modifier
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
            .clickable {
                bookViewModel.onBookClicked(book)
                navController.navigate(Routes.BookInfo.route)
            }
    ) {
        ListItem(
            headlineText = { Text(text = book.title) },
            supportingText = { Text(text = book.author) },
            leadingContent = {
                if (book.favorite) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "book",
                        tint = Color(0xFFFB8C00)
                    )
                }
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "book",
                    modifier = Modifier.clickable {
                        bookViewModel.deleteBook(book)
                    }
                )
            }
        )
    }
}