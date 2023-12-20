package com.catata.gestortareas.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.catata.gestortareas.database.entities.TaskEntity
import com.catata.gestortareas.ui.common.AuthorInfo
import com.catata.gestortareas.viewmodel.MainScreenViewModel
import com.catata.gestortareas.viewmodel.TaskViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    taskViewModel: TaskViewModel
) {
    val taskList by taskViewModel.taskList.observeAsState(initial = emptyList())

    val mainScreenViewModel = remember {
        MainScreenViewModel()
    }
    val inputTaskName by mainScreenViewModel.taskName.observeAsState(initial = "")
    val showDeleteIcon = remember {
        derivedStateOf {
            inputTaskName.isNotEmpty()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Lista de tareas:",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = inputTaskName,
                onValueChange = { mainScreenViewModel.onTaskNameChange(it) },
                label = { Text(text = "Tarea a añadir") },
                trailingIcon = {
                    if(showDeleteIcon.value) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Eliminar tarea",
                            modifier = Modifier.clickable { mainScreenViewModel.onTaskNameDelete() }
                        )
                    }
                }
            )
            Button(
                onClick = {
                    taskViewModel.addTask(inputTaskName)
                    mainScreenViewModel.onTaskNameDelete()
                },
                enabled = showDeleteIcon.value
            ) {
                Text(text = "Añadir")
            }
        }

        Divider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.onPrimary,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(7.7f)
        ) {

            LazyColumn(
                Modifier.fillMaxSize()
            ) {
                items(taskList) { task ->
                    TaskItem(
                        task = task,
                        onUpdate = {
                            taskViewModel.updateTask(task, it)
                        },
                        onDelete = {
                            taskViewModel.deleteTask(task)
                        }
                    )
                }
            }
        }

        AuthorInfo(modifier = Modifier.weight(1f))
    }
}

@Composable
fun TaskItem(
    task: TaskEntity,
    onUpdate: (Boolean) -> Unit,
    onDelete: () -> Unit,
) {
    ListItem(
        headlineContent = { Text(text = task.name)},
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        ),
        leadingContent = {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = {
                    onUpdate(it)
                }
            )
        },
        trailingContent = {
            IconButton(onClick = {
                onDelete()
            }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar tarea",
                )
            }
        },
        modifier = Modifier.padding(4.dp)
    )
}
