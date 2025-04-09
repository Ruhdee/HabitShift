package com.example.habitshift

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habitshift.ui.theme.Black
import com.example.habitshift.ui.theme.HabitShiftTheme
import com.example.habitshift.ui.theme.Purple
import com.example.habitshift.ui.theme.White

@Preview(showBackground = true)
@Composable
fun SuggestionsPagePreview() {
    HabitShiftTheme { SuggestionsPage() }
}

@Preview(showBackground = true)
@Composable
fun HabitButtonPreview() {
    HabitShiftTheme { HabitButton(toggleList = {}) }
}

@Composable
fun SuggestionsPage() {
    val scrollState = rememberScrollState()
    val selectedHabits: MutableList<String> = rememberSaveable { mutableListOf() }
    var enableNext by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(bottom = 50.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.suggestions),
            contentDescription = "Suggestions image",
            modifier = Modifier.size(320.dp)
        )
        Text(
            "Our Suggestions",
            modifier = Modifier
                .padding(bottom = 10.dp)
                .padding(horizontal = 20.dp),
            textAlign = TextAlign.Center
        )
        val listOfHabits = getHabitList()
        for (habit in listOfHabits) {
            HabitButton(
                habit, toggleList = fun(string: String) {
                    synchronized(Any()) {
                        if (selectedHabits.contains(string)) {
                            selectedHabits.remove(string)
                        } else {
                            selectedHabits.add(string)
                        }
                        Log.d("Check Selected Habits", selectedHabits.toString())
                        enableNext = selectedHabits.isNotEmpty()
                    }
                })
        }
        Button(
            onClick = { },
            shape = RoundedCornerShape(size = 12.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = Modifier.padding(vertical = 10.dp)
        ) { Text("Custom", style = MaterialTheme.typography.labelMedium) }
        Button(
            onClick = { },
            enabled = enableNext,
            shape = RoundedCornerShape(size = 12.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
        ) { Text("Next", style = MaterialTheme.typography.labelMedium) }


    }
}

@Composable
fun getHabitList(): List<String> {
    return listOf(
        "Reading Books", "Learning a Musical Instrument", "Journalism", "Workout", "Arts and Crafts"
    )

}

@Composable
fun HabitButton(
    name: String = "", toggleList: (String) -> Unit
) {
    var isChecked by rememberSaveable { mutableStateOf(false) }
    FilledIconToggleButton(
        checked = isChecked, onCheckedChange = {
            isChecked = !isChecked
            toggleList(name)
        }, modifier = Modifier
            .width(320.dp)
            .height(80.dp)
            .padding(vertical = 10.dp)
            .graphicsLayer(
                shadowElevation = if (!isChecked) 15.0f else 0f,
                shape = RoundedCornerShape(size = 12.dp),
                clip = true,
                ambientShadowColor = Purple,
                spotShadowColor = Purple
            ), shape = RoundedCornerShape(size = 12.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {

            Text(
                name,
                color = if (!isChecked) Black else White,
                style = MaterialTheme.typography.labelMedium
            )


        }

    }
}