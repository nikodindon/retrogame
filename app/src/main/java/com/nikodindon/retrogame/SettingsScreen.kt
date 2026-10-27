package com.nikodindon.retrogame

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(modifier: Modifier = Modifier, onBack: () -> Unit = {}) {
    var soundEnabled by remember { mutableStateOf(true) }
    var vibrationEnabled by remember { mutableStateOf(true) }

    Column(modifier = modifier.fillMaxSize().padding(24.dp)) {
        Text("PARAMÈTRES", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = soundEnabled, onCheckedChange = { soundEnabled = it })
            Spacer(modifier = Modifier.width(12.dp))
            Text("Son activé")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = vibrationEnabled, onCheckedChange = { vibrationEnabled = it })
            Spacer(modifier = Modifier.width(12.dp))
            Text("Vibration activée")
        }
        Spacer(modifier = Modifier.height(24.dp))

        Text("Version 0.1", style = MaterialTheme.typography.bodySmall)
        Text("Monétisation : non configurée", style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Retour au menu")
        }
    }
}
