package com.nikodindon.retrogame

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.decorView.systemUiVisibility = (
            android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
            android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
            android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        )
        setContent {
            MaterialTheme {
                var screen by remember { mutableStateOf("home") }
                when (screen) {
                    "game" -> GameScreen(
                        modifier = Modifier.fillMaxSize(),
                        onBackToMenu = { screen = "home" }
                    )
                    "settings" -> SettingsScreen(
                        modifier = Modifier.fillMaxSize(),
                        onBack = { screen = "home" }
                    )
                    else -> HomeScreen(
                        modifier = Modifier.fillMaxSize(),
                        onPlayTetris = { screen = "game" },
                        onOpenSettings = { screen = "settings" }
                    )
                }
            }
        }
    }
}
