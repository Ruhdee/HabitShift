package com.example.habitshift

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habitshift.ui.theme.HabitShiftTheme

@Preview(showBackground = true)
@Composable
fun FeedbackPagePreview() {
    HabitShiftTheme { FeedbackPage() }
}

@Composable
fun FeedbackPage() {
    var progress by rememberSaveable { mutableFloatStateOf(0.25f) }
    val numberOfQuestions = 4;
    Scaffold(topBar = {
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("${(progress * numberOfQuestions).toInt()} of $numberOfQuestions", modifier = Modifier.padding(bottom = 10.dp))
            LinearProgressIndicator(
                progress = { progress },
            )
        }

    }) { innerPadding ->
        Column { }

    }
}