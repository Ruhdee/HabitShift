package com.example.habitshift

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habitshift.ui.theme.Black
import com.example.habitshift.ui.theme.HabitShiftTheme
import com.example.habitshift.ui.theme.White


@Preview(showBackground = true, backgroundColor = 0xFF8F88EF)
@Composable
fun LoginScreenPreview() {
    HabitShiftTheme {
        LoginScreen()
    }
}

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Login Image
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Login image",
            modifier = Modifier.size(350.dp)
        )

        // Title Text
        Text(
            text = "Your Passport to Mental Success!",
            style = MaterialTheme.typography.titleLarge,
            color = White,
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 10.dp) // Add padding for spacing
        )

        // Email TextField
        OutlinedTextField(
            value = "",
            onValueChange = {},
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
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            ),
            shape = RoundedCornerShape(size = 12.dp),
            modifier = Modifier
                .width(320.dp)
                .height(70.dp)
                .padding(vertical = 10.dp)
        )

        // Password TextField
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = White,
                focusedContainerColor = White,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            ),
            shape = RoundedCornerShape(size = 12.dp),
            modifier = Modifier
                .width(320.dp)
                .height(70.dp)
                .padding(vertical = 10.dp)
        )

        // Register Button
        Button(
            onClick = {},
            shape = RoundedCornerShape(size = 36.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary),
            modifier = Modifier
                .width(360.dp)
                .height(109.dp)
                .padding(top = 45.dp, bottom = 10.dp)
        ) {
            Text(
                text = "Register",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
            )
        }



        // Continue with Google Button
        Button(
            onClick = {},
            shape = RoundedCornerShape(size = 36.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
            modifier = Modifier
                .width(360.dp)
                .height(74.dp)
                .padding(vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp), // Add padding for spacing
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Continue with Google",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Black,
                    modifier = Modifier
                        .padding(end = 10.dp) // Add padding between text and icon
                )
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google icon",
                    modifier = Modifier
                        .size(25.dp)
                )
            }
        }
    }
}