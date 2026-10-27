package com.nikodindon.retrogame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onPlayTetris: () -> Unit = {}) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // En-tête
        Text(
            text = "RETROGAME",
            style = MaterialTheme.typography.displayMedium,
            color = Color(0xFF00BCD4),
            letterSpacing = 2.sp
        )
        Text(
            text = "Arcade classique, interface moderne",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.LightGray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Catalogue
        Text("CATALOGUE", style = MaterialTheme.typography.titleMedium, color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))

        // Carte Tetris (disponible)
        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A2E))
        ) {
            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFF00BCD4), shape = RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("T", color = Color.Black, style = MaterialTheme.typography.headlineMedium)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("TETRIS", style = MaterialTheme.typography.titleMedium, color = Color.White)
                    Text("Disponible — 7 pièces classiques", style = MaterialTheme.typography.bodySmall, color = Color(0xFFCCCCCC))
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = onPlayTetris) {
                    Text("Jouer")
                }
            }
        }

        // Cartes futurs jeux (bientôt)
        listOf("Space Invaders", "Frogger", "Asteroids").forEach { name ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF12121A))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.size(48.dp).background(Color(0xFF333333), shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("?", color = Color(0xFF888888), style = MaterialTheme.typography.headlineMedium)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(name, style = MaterialTheme.typography.titleMedium, color = Color(0xFFAAAAAA))
                        Text("Bientôt disponible", style = MaterialTheme.typography.bodySmall, color = Color(0xFF666666))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("v0.1 — Première version installable", style = MaterialTheme.typography.bodySmall, color = Color(0xFF555555))
    }
}
