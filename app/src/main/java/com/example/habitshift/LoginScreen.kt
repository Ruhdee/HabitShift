package com.example.habitshift

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habitshift.ui.theme.HabitShiftTheme
import com.example.habitshift.ui.theme.LightBlue
import com.example.habitshift.ui.theme.White


@Preview(showBackground = true, backgroundColor = 0xFF8F88EF)
@Composable
fun LoginScreenPreview() {
    HabitShiftTheme {
        LoginScreen()
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = R.drawable.login), contentDescription = "Login image")
        Text(
            text = "Your Passport to Mental Success!",
            style = MaterialTheme.typography.titleLarge,
            color = LightBlue
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Email") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = White,
                focusedContainerColor = White,
            ),

            )
        OutlinedTextField(
            value = "", onValueChange = {}, label = { Text(text = "Password") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = White,
                focusedContainerColor = White,
            ),
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary)
        ) { Text(text = "Register") }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
        ) {
            Row(
                modifier = modifier.padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Continue with Google", modifier = modifier.padding(end = 10.dp))
                Image(
                    painter = painterResource(
                        id = R.drawable.google
                    ), contentDescription = "Google icon",
                    modifier = modifier.size(25.dp)
                )
            }
        }
    }
}