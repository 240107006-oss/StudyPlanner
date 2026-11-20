package com.example.studyplanner.navigation

object Routes {
    const val TASK_LIST = "task_list"
    const val ADD_TASK = "add_task"

    const val TASK_ID_ARG = "taskId"
    const val TASK_DETAIL = "detail/{$TASK_ID_ARG}"

    fun taskDetail(taskId: Int) = "detail/$taskId"
}