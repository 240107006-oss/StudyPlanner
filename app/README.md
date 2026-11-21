# StudyPlanner

Android app for managing study tasks and deadlines. Built with Kotlin, Jetpack Compose, MVVM and Navigation Compose.

## Author
- Danil Yevtushenko 240107006

## Main features
- View a scrollable list of study tasks
- Open task details (the task ID is passed as a navigation argument)
- Add a new task using a form
- Mark a task as done or in progress
- Delete a task
- Back navigation with a top bar arrow and the system back gesture

## Architecture (MVVM)
- **Model** (`data`): `Task` data class
- **ViewModel** (`viewmodel`): `TaskViewModel` keeps the UI state (`TaskUiState`) in a `StateFlow`
- **View** (`ui`): Composable screens and reusable components, Material 3 theme
- **Navigation** (`navigation`): `AppNavHost` with routes `task_list`, `detail/{taskId}`, `add_task`

## Project structure

com.example.studyplanner
├── MainActivity.kt
├── data/ Task.kt
├── viewmodel/ TaskViewModel.kt, TaskUiState.kt
├── navigation/ Routes.kt, AppNavHost.kt
└── ui/
├── components/ TaskCard.kt
├── screens/ TaskListScreen.kt, TaskDetailScreen.kt, AddTaskScreen.kt
└── theme/


## Tech stack
Kotlin, Jetpack Compose, Material 3, ViewModel, StateFlow, Navigation Compose