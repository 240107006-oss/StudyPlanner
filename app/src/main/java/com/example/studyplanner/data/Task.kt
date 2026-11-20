package com.example.studyplanner.data

data class Task(
    val id: Int,
    val title: String,
    val subject: String,
    val description: String = "",
    val dueDate: String = "",
    val isDone: Boolean = false
)