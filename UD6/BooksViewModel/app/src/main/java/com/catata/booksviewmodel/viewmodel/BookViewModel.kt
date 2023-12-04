package com.catata.booksviewmodel.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catata.booksviewmodel.model.Book
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class BookViewModel : ViewModel() {
    // Los LiveData (estados) solo deben de poder cambiar desde el View Model, por ello se declaran private.
    // Para acceder al valor de los estados desde el exterior del View Model se crea una variable
    //  no mutable que almacenará el mismo valor que la variable privada

    // Lista de libros
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    // Libro seleccionado
    private val _selectedBook = MutableLiveData<Book>()
    val selectedBook: LiveData<Book> = _selectedBook

    // Variable para indicar que se están obteniendo los datos del repositorio
    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // Cuando instancia un objeto BookViewModel tras llamar al constructor se ejecuta el bloque init
    init {
//        // Corrutina: coroutineScope
//        viewModelScope.launch {
//            _isLoading.value = true
//            delay(2000)
//            _books.value = Book.getData()
//            _isLoading.value = false
//        }
        loadBookList()
    }

    fun deleteBook(book: Book) {
        // Con API o BBDD se mandaría el id y se borraría.
        //  Por último se obtendría la lista actualizada y se actualizaría el LiveData

        // En este caso se elimina el libro de la lista y se actualiza el LiveData
        _books.value = _books.value?.filter { it != book }
    }

    // Al pulsar sobre un libro se almacena como seleccionado.
    fun onBookClicked(book: Book) {
        _selectedBook.value = book
    }

    // Para marcar/desmarcar el libro como favorito
    fun markAsFavorite(book: Book) {
        _books.value?.map {
            if (it == book) it.favorite = !it.favorite
        }
    }

    fun searchBook(searchString: String) {
        val searchList = mutableListOf<Book>()
        _books.value?.forEach {
            val book = it.copy()
            book.visible = book.title.contains(searchString, true)
            searchList.add(book)
        }
        _books.value = searchList
    }

    fun resetSearchList() {
        val searchList = mutableListOf<Book>()
        _books.value?.forEach {
            val book = it.copy()
            book.visible = true
            searchList.add(book)
        }
        _books.value = searchList
    }

    fun loadBookList() {
        // Corrutina: coroutineScope
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            _books.value = Book.getData()
            _isLoading.value = false
        }
    }
}



