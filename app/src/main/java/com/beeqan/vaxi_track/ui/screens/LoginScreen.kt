
package com.beeqan.vaxi_track.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(
    onNavigateToRoleSelection: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("English") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Section (30%) - Logo and Title
        Column(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // App Logo with gradient background
            Surface(
                modifier = Modifier
                    .size(96.dp)
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(24.dp),
                shadowElevation = 8.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF667eea),
                                    Color(0xFF5563d1)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    // Shield Check Icon placeholder
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "VaxiTrack Logo",
                        tint = Color.White,
                        modifier = Modifier.size(56.dp)
                    )
                }
            }

            // App Name
            Text(
                text = "VaxiTrack",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212121)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Tagline
            Text(
                text = "Track Vaccinations, Protect Lives",
                fontSize = 14.sp,
                color = Color(0xFF757575)
            )
        }

        // Middle Section (50%) - Login Form
        Column(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            // Username Input
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                placeholder = { Text("Username") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Username",
                        tint = Color(0xFF757575)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF667eea),
                    unfocusedBorderColor = Color(0xFFE0E0E0),
                    focusedLeadingIconColor = Color(0xFF667eea),
                    unfocusedLeadingIconColor = Color(0xFF757575)
                ),
                singleLine = true
            )

            // Password Input
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                placeholder = { Text("Password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password",
                        tint = Color(0xFF757575)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility
                            else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Hide password"
                            else "Show password",
                            tint = Color(0xFF757575)
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF667eea),
                    unfocusedBorderColor = Color(0xFFE0E0E0),
                    focusedLeadingIconColor = Color(0xFF667eea),
                    unfocusedLeadingIconColor = Color(0xFF757575)
                ),
                singleLine = true
            )

            // Forgot Password
            Text(
                text = "Forgot Password?",
                fontSize = 14.sp,
                color = Color(0xFF667eea),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { /* Handle forgot password */ }
                    .padding(bottom = 24.dp)
            )

            // Login Button
            Button(
                onClick = onNavigateToRoleSelection,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF667eea)
                ),
                shape = RoundedCornerShape(8.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Text(
                    text = "LOGIN",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Bottom Section (20%) - Register and Language
        Column(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Register Link
            Row(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(
                    text = "Don't have an account? ",
                    fontSize = 14.sp,
                    color = Color(0xFF757575)
                )
                Text(
                    text = "Register",
                    fontSize = 14.sp,
                    color = Color(0xFF667eea),
                    modifier = Modifier.clickable { onNavigateToRegister() }
                )
            }

            // Language Selector
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "English",
                    fontSize = 14.sp,
                    color = if (selectedLanguage == "English") Color(0xFF667eea)
                    else Color(0xFF757575),
                    modifier = Modifier.clickable { selectedLanguage = "English" }
                )
                Text(
                    text = " | ",
                    fontSize = 14.sp,
                    color = Color(0xFF757575)
                )
                Text(
                    text = "Kinyarwanda",
                    fontSize = 14.sp,
                    color = if (selectedLanguage == "Kinyarwanda") Color(0xFF667eea)
                    else Color(0xFF757575),
                    modifier = Modifier.clickable { selectedLanguage = "Kinyarwanda" }
                )
                Text(
                    text = " | ",
                    fontSize = 14.sp,
                    color = Color(0xFF757575)
                )
                Text(
                    text = "Français",
                    fontSize = 14.sp,
                    color = if (selectedLanguage == "Français") Color(0xFF667eea)
                    else Color(0xFF757575),
                    modifier = Modifier.clickable { selectedLanguage = "Français" }
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onNavigateToRoleSelection = { /* no-op */ },
        onNavigateToRegister = { /* no-op */ }
    )
}