package com.example.studyplanner.viewmodel

import androidx.lifecycle.ViewModel
import com.example.studyplanner.data.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        TaskUiState(
            tasks = listOf(
                Task(1, "Android group project", "Mobile Development", "Finish MVVM and navigation", "Sat"),
                Task(2, "Lab report", "Networks", "Answer theory questions", "Mon"),
                Task(3, "Prepare for quiz", "Databases", "Chapters 4-6", "Wed")
            )
        )
    )
    val uiState: StateFlow<TaskUiState> = _uiState.asStateFlow()

    private var nextId = 4

    fun getTask(id: Int): Task? = _uiState.value.tasks.find { it.id == id }

    fun addTask(title: String, subject: String, description: String, dueDate: String) {
        val task = Task(nextId++, title, subject, description, dueDate)
        _uiState.update { it.copy(tasks = it.tasks + task) }
    }

    fun toggleDone(id: Int) {
        _uiState.update { state ->
            state.copy(tasks = state.tasks.map {
                if (it.id == id) it.copy(isDone = !it.isDone) else it
            })
        }
    }

    fun deleteTask(id: Int) {
        _uiState.update { state ->
            state.copy(tasks = state.tasks.filter { it.id != id })
        }
    }
}