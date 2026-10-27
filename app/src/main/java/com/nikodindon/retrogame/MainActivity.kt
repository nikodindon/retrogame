package com.nikodindon.retrogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var showGame by remember { mutableStateOf(false) }
                if (showGame) {
                    GameScreen(modifier = Modifier.fillMaxSize())
                } else {
                    HomeScreen(modifier = Modifier.fillMaxSize(), onPlayTetris = { showGame = true })
                }
            }
        }
    }
}
