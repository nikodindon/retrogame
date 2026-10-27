package com.nikodindon.retrogame

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun FroggerScreen(modifier: Modifier = Modifier, onBackToMenu: () -> Unit = {}) {
    val engine = remember { FroggerEngine() }
    var refresh by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        engine.reset()
        refresh++
        while (true) {
            delay(700L)
            if (!engine.gameOver) {
                engine.step()
                refresh++
            }
        }
    }

    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("RETROGAME  FROGGER", style = MaterialTheme.typography.titleMedium, color = Color(0xFF2ECC71))
            Text("Score: ${engine.score}", color = Color.White)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.weight(1f).fillMaxWidth().border(2.dp, Color.DarkGray)) {
            for (r in 0 until 15) {
                for (c in 0 until 10) {
                    val filled = engine.isCellFilled(c, r)
                    val isCar = engine.carsPublic.any { it.second == c && it.first == r }
                    val isLog = engine.logsPublic.any { it.second == c && it.first == r }
                    val color = when {
                        filled && (c == engine.playerCol && r == engine.playerRow) -> Color(0xFF00BCD4)
                        isCar -> Color.Red
                        isLog -> Color(0xFF8B4513)
                        r == 0 -> Color(0xFF228B22)
                        else -> Color.Black
                    }
                    Box(modifier = Modifier
                        .width(28.dp)
                        .height(28.dp)
                        .offset(x = (c * 28).dp, y = (r * 28).dp)
                        .background(color)
                        .border(0.5.dp, Color(0xFF222222))
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { engine.moveUp(); refresh++ }) { Text("Up") }
            Button(onClick = { engine.moveLeft(); refresh++ }) { Text("<") }
            Button(onClick = { engine.moveRight(); refresh++ }) { Text(">") }
            Button(onClick = { engine.moveDown(); refresh++ }) { Text("Dn") }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { engine.reset(); refresh++ }) { Text("Restart") }
            Button(onClick = onBackToMenu) { Text("Menu") }
        }
        if (engine.gameOver) {
            Box(modifier = Modifier.fillMaxWidth().padding(8.dp).background(Color(0xAA000000)), contentAlignment = Alignment.Center) {
                Text("PERDU ! Score: ${engine.score}", color = Color.Red, style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}
