package com.catata.booksviewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main2() = runBlocking {
    launch(Dispatchers.Default) {
        // Código de la corrutina ejecutado en el hilo por defecto del pool de hilos
        delay(1000)
        println("Corrutina ejecutada en ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        // Código de la corrutina ejecutado en el hilo por defecto del pool de hilos
        delay(1000)
        println("Corrutina ejecutada en ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        // Código de la corrutina ejecutado en el hilo de entrada/salida del pool de hilos
        delay(1000)
        println("Corrutina ejecutada en ${Thread.currentThread().name}")
    }

    delay(2000)
}

fun main() = runBlocking {
    val job = Job()  // Crear un nuevo Job
    val context: CoroutineContext = Dispatchers.Default + job  // Combinar el dispatcher por defecto y el Job

    GlobalScope.launch(
        Dispatchers.Main
    ) {

    }

    CoroutineScope(Dispatchers.IO).launch {

    }

    launch(context) {
        // Código de la corrutina
        delay(2000)
        println("Corrutina ejecutada en ${Thread.currentThread().name}")
    }

    delay(1000)


    job.cancel()  // Cancelar la corrutina después de 2 segundos
}