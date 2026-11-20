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
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.studyplanner.R
import com.example.studyplanner.ui.screens.TaskDetailScreen

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
                onTaskClick = { taskId ->
                    navController.navigate(Routes.taskDetail(taskId))
                },
                onAddClick = {}
            )
        }
        composable(
            route = Routes.TASK_DETAIL,
            arguments = listOf(navArgument(Routes.TASK_ID_ARG) { type = NavType.IntType })
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt(Routes.TASK_ID_ARG) ?: 0
            val task = uiState.tasks.find { it.id == taskId }

            if (task != null) {
                TaskDetailScreen(
                    task = task,
                    onBackClick = { navController.navigateUp() }
                )} else {
                Text(stringResource(R.string.task_not_found))
            }
        }
    }
}