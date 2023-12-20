package com.catata.gestortareas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.catata.gestortareas.database.dao.TaskDAO
import com.catata.gestortareas.database.entities.TaskEntity

@Database(entities = arrayOf(TaskEntity::class), version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDAO(): TaskDAO

    companion object {  // Patrón Singleton
        private var instance: TaskDAO? = null

        fun getInstance(context: Context): TaskDAO {
            // el método databaseBuilder devuelve una referencia a la base de datos
            return instance ?: Room.databaseBuilder(context, TasksDatabase::class.java, "tasks-db")
                .build().taskDAO().also { instance = it }
        }
    }
}