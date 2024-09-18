package com.example.studying

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.studying.ui.theme.StudyingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
                        onLoginClick = { username, password ->
                            if (username == "admin" && password == "admin") {
                                val intent = Intent(this, HomePageActivity::class.java).apply {
                                    putExtra("USERNAME", username)
                                }
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier, onLoginClick: (String, String) -> Unit) {
    val nameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Login")
        }
        TextField(
            value = nameState.value,
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
            onValueChange = { nameState.value = it },
            label = { Text("Enter your name") }
        )
        TextField(
            value = passwordState.value,
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp, bottom = 24.dp),
            onValueChange = { passwordState.value = it },
            label = { Text("Enter your password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = { onLoginClick(nameState.value, passwordState.value) }, modifier = Modifier.fillMaxWidth()) {
            Text("Login")
        }
    }
}