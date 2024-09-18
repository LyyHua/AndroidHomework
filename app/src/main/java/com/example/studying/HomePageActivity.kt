package com.example.studying

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studying.ui.theme.StudyingTheme

class HomePageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val username = intent.getStringExtra("USERNAME") ?: "Guest"
        setContent {
            StudyingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomePageScreen(
                        username = username,
                        modifier = Modifier.padding(innerPadding),
                        onSignOutClick = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HomePageScreen(username: String, modifier: Modifier = Modifier, onSignOutClick: () -> Unit) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Welcome, $username!", modifier = Modifier.padding(bottom = 24.dp))
        Text(text = "Description: Ly is a handsome guy", modifier = Modifier.padding(bottom = 24.dp))
        Button(onClick = onSignOutClick, modifier = Modifier.fillMaxWidth()) {
            Text("Sign Out")
        }
    }
}