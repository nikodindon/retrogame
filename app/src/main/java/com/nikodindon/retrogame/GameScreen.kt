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
fun GameScreen(modifier: Modifier = Modifier) {
    val engine = remember { GameEngine() }
    var gridState by remember { mutableStateOf(engine.getGridSnapshot()) }
    var score by remember { mutableStateOf(0) }
    var level by remember { mutableStateOf(1) }
    var lines by remember { mutableStateOf(0) }
    var over by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        engine.reset()
        while (true) {
            delay(600L)
            if (!over) {
                val locked = engine.step()
                gridState = engine.getGridSnapshot()
                score = engine.score
                level = engine.level
                lines = engine.lines
                over = engine.gameOver
            }
        }
    }

    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("RetroGame Tetris", style = MaterialTheme.typography.headlineSmall)
            Column(horizontalAlignment = Alignment.End) {
                Text("Score: $score")
                Text("Level: $level  Lines: $lines")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.weight(1f).fillMaxWidth().border(2.dp, Color.DarkGray)) {
            for (r in 0 until 20) {
                for (c in 0 until 10) {
                    val filled = engine.getCell(c, r)
                    Box(modifier = Modifier
                        .width(28.dp)
                        .height(28.dp)
                        .offset(x = (c * 28).dp, y = (r * 28).dp)
                        .background(if (filled) Color(0xFF00BCD4) else Color.Black)
                        .border(0.5.dp, Color(0xFF333333))
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { engine.moveLeft() }) { Text("<") }
            Button(onClick = { engine.rotate() }) { Text("Rot") }
            Button(onClick = { engine.hardDrop() }) { Text("Drop") }
            Button(onClick = { engine.moveRight() }) { Text(">") }
            Button(onClick = { engine.reset(); over = false; gridState = engine.getGridSnapshot() }) { Text("Restart") }
        }
    }
}
