package com.example.habitshift

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habitshift.ui.theme.Black
import com.example.habitshift.ui.theme.Blue
import com.example.habitshift.ui.theme.HabitShiftTheme
import com.example.habitshift.ui.theme.White
import java.nio.file.WatchEvent

@Preview(showBackground = true)
@Composable
fun RegistrationPagePreview() {
    HabitShiftTheme { RegistrationPage() }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationPage() {
    val scrollState = rememberScrollState()
    var selectedOption by remember { mutableIntStateOf(-1) }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // State to track the selected age and the visibility of the dropdown menu
    var selectedAge by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    var isChecked by remember { mutableStateOf(false) }

    // List of ages to be displayed in the dropdown
    val ages = (13..100).toList().map { it.toString() }
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(bottom = 50.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Register Now!",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.Center) // Center the text within the Box
                            .padding(end = 56.dp) // Add padding to account for the navigation icon
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle the back button click */ }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.background
            )
        )
        Image(
            painter = painterResource(R.drawable.signup),
            contentDescription = "Signup image",
            modifier = Modifier.size(300.dp)
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            placeholder = {
                Text(
                    text = "Name",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = White,
                focusedContainerColor = White,

                ),
            shape = RoundedCornerShape(size = 12.dp),
            modifier = Modifier
                .width(320.dp)
                .height(54.dp),
            textStyle = MaterialTheme.typography.labelMedium
        )
        Column(
            modifier = Modifier
                .width(320.dp)
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier
                    .width(320.dp)
                    .height(74.dp)
                    .padding(vertical = 10.dp),
            ) {
                OutlinedTextField(
                    value = selectedAge,
                    onValueChange = { selectedAge = it },
                    placeholder = {
                        Text(
                            "Select Age",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary
                        )  // Ensure the menu opens from the TextField
                    },
                    readOnly = true,  // Disable direct text input
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown"
                            )
                        }
                    },
                    modifier = Modifier
                        .width(320.dp)
                        .menuAnchor(),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = White,
                        focusedContainerColor = White,

                        ),
                    shape = RoundedCornerShape(size = 12.dp),
                    textStyle = MaterialTheme.typography.labelMedium
                )

                // Dropdown menu items
                ExposedDropdownMenu(
                    expanded = expanded, onDismissRequest = { expanded = false }) {
                    ages.forEach { age ->
                        DropdownMenuItem(text = {
                            Text(
                                age, style = MaterialTheme.typography.labelMedium
                            )
                        }, onClick = {
                            selectedAge = age
                            expanded = false
                        })
                    }
                }
            }
        }
        Column(
            modifier = Modifier.width(320.dp), horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Select Gender", style = MaterialTheme.typography.labelMedium
            )
            // Radio Button 1
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == 0,  // Check if this radio button is selected
                    onClick = { selectedOption = 0 }  // Set selected option to 0 when clicked
                )
                Text("Male", style = MaterialTheme.typography.labelMedium)
            }

            // Radio Button 2
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == 1,  // Check if this radio button is selected
                    onClick = { selectedOption = 1 }  // Set selected option to 1 when clicked
                )
                Text("Female", style = MaterialTheme.typography.labelMedium)
            }

            // Radio Button 3
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == 2,  // Check if this radio button is selected
                    onClick = { selectedOption = 2 }  // Set selected option to 2 when clicked
                )
                Text("Other", style = MaterialTheme.typography.labelMedium)
            }
        }
        // Email TextField
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text(
                    text = "Email",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = White,
                focusedContainerColor = White,
            ),
            shape = RoundedCornerShape(size = 12.dp),
            modifier = Modifier
                .width(320.dp)
                .height(74.dp)
                .padding(vertical = 10.dp),
            textStyle = MaterialTheme.typography.labelMedium
        )

        // Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = White,
                focusedContainerColor = White,
            ),
            shape = RoundedCornerShape(size = 12.dp),
            modifier = Modifier
                .width(320.dp)
                .height(74.dp)
                .padding(vertical = 10.dp),
            textStyle = MaterialTheme.typography.labelMedium,
        )
        Row(modifier = Modifier.width(346.dp), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isChecked, onCheckedChange = { checked ->
                    isChecked = checked
                })
            Text(
                text = "I agree to the ", style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "Terms and Conditions",
                style = MaterialTheme.typography.labelMedium,
                color = Blue,
                modifier = Modifier.clickable { })
        }
        Row(modifier = Modifier.width(320.dp), horizontalArrangement = Arrangement.Start){Button(
            onClick = { },
            enabled = isChecked,
            shape = RoundedCornerShape(size = 12.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
        ) { Text("Register", style = MaterialTheme.typography.labelMedium) }}

    }

}