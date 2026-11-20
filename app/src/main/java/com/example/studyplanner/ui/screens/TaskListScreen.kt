package com.example.studyplanner.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.tooling.preview.Preview
import com.example.studyplanner.ui.theme.StudyPlannerTheme
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.studyplanner.R
import com.example.studyplanner.data.Task
import com.example.studyplanner.ui.components.TaskCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(
    tasks: List<Task>,
    onTaskClick: (Int) -> Unit,
    onAddClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.tasks_title)) })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(R.string.add_task)
                )
            }
        }
    ) { innerPadding ->
        if (tasks.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(stringResource(R.string.no_tasks))
            }
        } else {
            LazyColumn(contentPadding = innerPadding) {
                items(tasks) { task ->
                    TaskCard(task = task, onClick = { onTaskClick(task.id) })
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TaskListScreenPreview() {
    StudyPlannerTheme {
        TaskListScreen(
            tasks = listOf(
                Task(1, "Android group project", "Mobile Development", "Finish MVVM", "Sat"),
                Task(2, "Lab report", "Networks", "Answer questions", "Mon", isDone = true),
                Task(3, "Prepare for quiz", "Databases", "Chapters 4-6", "Wed")
            ),
            onTaskClick = {},
            onAddClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListScreenEmptyPreview() {
    StudyPlannerTheme {
        TaskListScreen(
            tasks = emptyList(),
            onTaskClick = {},
            onAddClick = {}
        )
    }
}