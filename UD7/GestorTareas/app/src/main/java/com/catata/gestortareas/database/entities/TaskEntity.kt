package com.catata.gestortareas.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name ="name" ) var name: String,
    @ColumnInfo(name ="name" ) var isDone: Boolean = false
)
