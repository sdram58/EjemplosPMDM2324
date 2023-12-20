package com.catata.gestortareas.database.dao

import androidx.lifecycle.LiveData
import com.catata.gestortareas.database.entities.TaskEntity


interface GeneralDAO {
    // Devuelve la lista de tareas dentro de un LiveData
    fun getAllTasks(): LiveData<MutableList<TaskEntity>>

    // Devuelve la cantidad de elementos que su name coincida con el argumento
    suspend fun taskExists(name: String): Int

    // Devuelve una tarea a partir de su id
    suspend fun getTaskById(id: Long): TaskEntity

    // Añade una tarea y devuelve su id
    suspend fun addTask(taskEntity: TaskEntity): Long

    // Actualiza la tarea y devuelve el nº de filas afectadas
    suspend fun updateTask(taskEntity: TaskEntity): Int

    // Borra la tarea y devuelve el nº de filas afectadas
    suspend fun deleteTask(taskEntity: TaskEntity): Int
}