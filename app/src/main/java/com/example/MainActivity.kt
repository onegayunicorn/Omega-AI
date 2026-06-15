package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.TextSecondary

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        AssistantSettingsScreen()
      }
    }
  }
}

@Composable
fun AssistantSettingsScreen() {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    containerColor = MaterialTheme.colorScheme.background
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
      Text(
        text = "Default digital assistant app",
        style = MaterialTheme.typography.headlineSmall,
        color = MaterialTheme.colorScheme.onBackground
      )
      
      Text(
        text = "The assist app will be able to read information about apps in use on your system, including information displayed on your screen or accessible via the microphone.",
        style = MaterialTheme.typography.bodySmall,
        color = TextSecondary,
        modifier = Modifier.padding(vertical = 12.dp)
      )

      // Placeholder for Options List
      // In a real app, this would be a LazyColumn of options
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary)
      ) {
        ListItem(
          headlineContent = { Text("Omega AI") },
          supportingContent = { Text("Sovereign AI Core") },
          leadingContent = { Text("Ω") }
        )
      }
    }
  }
}
