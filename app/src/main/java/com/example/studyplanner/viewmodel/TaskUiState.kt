package com.example.studyplanner.viewmodel

import com.example.studyplanner.data.Task

data class TaskUiState(
    val tasks: List<Task> = emptyList()
)