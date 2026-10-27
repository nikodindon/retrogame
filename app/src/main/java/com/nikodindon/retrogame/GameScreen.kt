package com.nikodindon.retrogame

import android.media.MediaPlayer
import android.media.ToneGenerator
import android.net.Uri
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun GameScreen(modifier: Modifier = Modifier, onBackToMenu: () -> Unit = {}) {
    val engine = remember { GameEngine() }
    var refresh by remember { mutableStateOf(0) }
    val toneGen = remember { ToneGenerator(android.media.AudioManager.STREAM_MUSIC, 80) }

    LaunchedEffect(Unit) {
        engine.reset()
        refresh++
        while (true) {
            delay(500L)
            if (!engine.gameOver) {
                val locked = engine.step()
                if (locked) toneGen.startTone(ToneGenerator.TONE_PROP_BEEP, 100)
                refresh++
            } else {
                toneGen.startTone(ToneGenerator.TONE_SUP_ERROR, 300)
                refresh++
            }
        }
    }

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
                if (cx in 0 until engine.cols && cy in 0 until engine.rows) result.add(Pair(cx, cy))
            }
        }
        result
    }

    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        // Bandeau amélioré avec fond semi-transparent
        Box(modifier = Modifier.fillMaxWidth().background(Color(0xFF111122)).border(1.dp, Color(0xFF333333)).padding(8.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("RETROGAME  TETRIS", style = MaterialTheme.typography.titleLarge, color = Color.Cyan)
                Column(horizontalAlignment = Alignment.End) {
                    Text("Score ${engine.score}  L${engine.level}  ${engine.lines}L", style = MaterialTheme.typography.bodyMedium, color = Color.White)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Zone de jeu
        Box(modifier = Modifier.weight(1f).fillMaxWidth().border(2.dp, Color(0xFF333333)).background(Color.Black)) {
            for (r in 0 until 20) {
                for (c in 0 until 10) {
                    val filled = visibleCells.contains(Pair(c, r))
                    Box(modifier = Modifier
                        .width(28.dp)
                        .height(28.dp)
                        .offset(x = (c * 28).dp, y = (r * 28).dp)
                        .background(if (filled) Color(0xFF00BCD4) else Color.Black)
                        .border(0.5.dp, Color(0xFF222222))
                    )
                }
            }
            // Écran de fin
            if (engine.gameOver) {
                Box(modifier = Modifier.fillMaxSize().background(Color(0xAA000000)), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("PERDU !", style = MaterialTheme.typography.displayMedium, color = Color.Red)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Score final : ${engine.score}", style = MaterialTheme.typography.titleMedium, color = Color.White)
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { engine.reset(); refresh++ }) { Text("Rejouer") }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Contrôles + bouton menu
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { engine.moveLeft(); refresh++ }) { Text("<") }
            Button(onClick = { engine.rotate(); refresh++ }) { Text("Rot") }
            Button(onClick = { engine.hardDrop(); refresh++ }) { Text("Drop") }
            Button(onClick = { engine.moveRight(); refresh++ }) { Text(">") }
            Button(onClick = { engine.reset(); refresh++ }) { Text("Restart") }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = onBackToMenu) {
                Text("Menu")
            }
        }
    }
}
