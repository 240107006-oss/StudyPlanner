package com.example.studyplanner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studyplanner.R
import com.example.studyplanner.data.Task
import com.example.studyplanner.ui.theme.StudyPlannerTheme


@Composable
fun TaskDetailScreen(
    task: Task,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = task.title,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = task.subject,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(R.string.due_date, task.dueDate))
        Text(
            stringResource(
                if (task.isDone) R.string.status_done else R.string.status_in_progress
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = task.description,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskDetailScreenPreview() {
    StudyPlannerTheme {
        TaskDetailScreen(
            task = Task(
                id = 1,
                title = "Android group project",
                subject = "Mobile Development",
                description = "Finish MVVM and navigation",
                dueDate = "Sat"
            )
        )
    }
}