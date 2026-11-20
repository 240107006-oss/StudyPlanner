package com.example.studyplanner.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studyplanner.ui.screens.TaskListScreen
import com.example.studyplanner.viewmodel.TaskViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: TaskViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Routes.TASK_LIST,
        modifier = modifier
    ) {
        composable(Routes.TASK_LIST) {
            TaskListScreen(
                tasks = uiState.tasks,
                onTaskClick = {},
                onAddClick = {}
            )
        }
    }
}