package com.catata.gestortareas.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.catata.gestortareas.database.dao.TaskDAO
import com.catata.gestortareas.database.TasksDatabase
import com.catata.gestortareas.database.entities.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    // Se crea una instancia del DAO
    val taskDAO: TaskDAO = TasksDatabase.getInstance(application)

    // Se crea un LiveData para la lista de tareas que observará al "SELECT *" del DAO
    var taskList: LiveData<MutableList<TaskEntity>> = MutableLiveData()

    // Función que inicializa la lista de tareas desde la BBDD
    fun getAllTasks(){
        viewModelScope.launch(Dispatchers.IO) {
            taskList = taskDAO.getAllTasks()
        }
    }

    // Función que añade una tarea a la base de datos
    fun addTask(task: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (taskDAO.taskExists(task) == 0) {
                taskDAO.addTask(TaskEntity(name = task))
            }
        }
    }

    // Función que elimina una tarea de la base de datos
    fun deleteTask(task: TaskEntity){
        viewModelScope.launch(Dispatchers.IO) {
            taskDAO.deleteTask(task)
        }
    }

    // Función que actualiza una tarea de la base de datos.
    fun updateTask(task: TaskEntity, isDone: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            taskDAO.updateTask(task.copy(isDone = isDone))
        }
    }
}