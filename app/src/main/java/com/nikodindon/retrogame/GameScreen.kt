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
    var refresh by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        engine.reset()
        refresh++
        while (true) {
            delay(500L)
            if (!engine.gameOver) {
                engine.step()
                refresh++
            }
        }
    }

    // Calcul des cellules visibles (grid + pièce courante)
    val visibleCells = remember(refresh) {
        val result = mutableSetOf<Pair<Int, Int>>()
        for (r in 0 until engine.rows) {
            for (c in 0 until engine.cols) {
                if (engine.getCell(c, r)) result.add(Pair(c, r))
            }
        }
        engine.current?.let { piece ->
            for ((dx, dy) in piece.cells) {
                val cx = piece.x + dx
                val cy = piece.y + dy
                if (cx in 0 until engine.cols && cy in 0 until engine.rows) {
                    result.add(Pair(cx, cy))
                }
            }
        }
        result
    }

    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("RetroGame Tetris", style = MaterialTheme.typography.headlineSmall)
            Column(horizontalAlignment = Alignment.End) {
                Text("Score: ${engine.score}")
                Text("Level: ${engine.level}  Lines: ${engine.lines}")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.weight(1f).fillMaxWidth().border(2.dp, Color.DarkGray)) {
            for (r in 0 until 20) {
                for (c in 0 until 10) {
                    val filled = visibleCells.contains(Pair(c, r))
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
            Button(onClick = { engine.moveLeft(); refresh++ }) { Text("<") }
            Button(onClick = { engine.rotate(); refresh++ }) { Text("Rot") }
            Button(onClick = { engine.hardDrop(); refresh++ }) { Text("Drop") }
            Button(onClick = { engine.moveRight(); refresh++ }) { Text(">") }
            Button(onClick = { engine.reset(); refresh++ }) { Text("Restart") }
        }
    }
}
