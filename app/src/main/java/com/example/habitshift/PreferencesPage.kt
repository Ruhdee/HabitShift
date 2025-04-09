package com.example.habitshift

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habitshift.ui.theme.Black
import com.example.habitshift.ui.theme.HabitShiftTheme
import com.example.habitshift.ui.theme.White

@Preview(showBackground = true)
@Composable
fun PreferencesPagePreview() {
    HabitShiftTheme { PreferencesPage() }
}

@Preview(showBackground = true)
@Composable
fun AppButtonPreview() {
    HabitShiftTheme { AppButton(toggleList = {}) }
}

@Composable
fun PreferencesPage() {
    val scrollState = rememberScrollState()
    val selectedApps: MutableList<String> = rememberSaveable { mutableListOf() }
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
            painter = painterResource(R.drawable.preferences),
            contentDescription = "Preferences image",
            modifier = Modifier.width(360.dp)
        )
        Text(
            "Which app/apps do you want to swap for better habits ?",
            modifier = Modifier
                .padding(bottom = 10.dp)
                .padding(horizontal = 20.dp),
            textAlign = TextAlign.Center
        )
        val listOfAppButtonBuilders = getAppButtonList()
        for (builder in listOfAppButtonBuilders) {
            AppButton(
                builder.painter,
                builder.description,
                builder.name,
                toggleList = fun(string: String) {
                    synchronized(Any()) {
                        if (selectedApps.contains(string)) {
                            selectedApps.remove(string)
                        } else {
                            selectedApps.add(string)
                        }
                        Log.d("Check Selected Apps", selectedApps.toString())
                        enableNext = selectedApps.isNotEmpty()
                    }
                })
        }
        Button(
            onClick = { },
            enabled = enableNext,
            shape = RoundedCornerShape(size = 12.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = Modifier.padding(vertical = 10.dp)
        ) { Text("Next", style = MaterialTheme.typography.labelMedium) }


    }
}

data class ButtonBuilderItem(
    val painter: Painter, val description: String, val name: String
)

@Composable
fun getAppButtonList(): List<ButtonBuilderItem> {
    return listOf(
        ButtonBuilderItem(
            painter = painterResource(R.drawable.youtube),
            description = "Youtube image",
            name = "Youtube"
        ),
        ButtonBuilderItem(
            painter = painterResource(R.drawable.instagram),
            description = "Instagram image",
            name = "Instagram"
        ),
        ButtonBuilderItem(
            painter = painterResource(R.drawable.snapchat),
            description = "Snapchat image",
            name = "Snapchat"
        ),
        ButtonBuilderItem(
            painter = painterResource(R.drawable.facebook),
            description = "Facebook image",
            name = "Facebook"
        ),
        ButtonBuilderItem(
            painter = painterResource(R.drawable.twitter),
            description = "Twitter image",
            name = "Twitter"
        ),
    )
}

@Composable
fun AppButton(
    painter: Painter = painterResource(R.drawable.youtube),
    description: String = "",
    name: String = "",
    toggleList: (String) -> Unit
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
                shadowElevation = if (!isChecked) 15.0f else 0f, shape = RoundedCornerShape(size = 12.dp), clip = true
            ), shape = RoundedCornerShape(size = 12.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painter, contentDescription = description, modifier = Modifier.size(40.dp)

            )
            Text(
                name,
                modifier = Modifier.padding(start = 16.dp),
                color = if (!isChecked) Black else White
            )

        }

    }

}