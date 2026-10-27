package com.nikodindon.retrogame

class FroggerEngine {
    val rows = 15
    var playerRow = 14
    var playerCol = 5
    var score = 0
    var gameOver = false
    private val cars = mutableListOf<Pair<Int, Int>>()
    private val logs = mutableListOf<Pair<Int, Int>>()
    val carsPublic: List<Pair<Int, Int>> get() = cars.toList()
    val logsPublic: List<Pair<Int, Int>> get() = logs.toList()

    fun reset() {
        playerRow = 14; playerCol = 5; score = 0; gameOver = false
        cars.clear(); logs.clear()
        for (r in 5..10) {
            for (c in 0..9 step 3) cars.add(Pair(r, c))
        }
        for (r in 3..7) {
            logs.add(Pair(2, r))
            logs.add(Pair(5, r))
            logs.add(Pair(8, r))
        }
    }

    fun moveUp() { if (playerRow > 0) playerRow--; if (playerRow == 0) { score += 100; reset(); reset() } }
    fun moveDown() { if (playerRow < rows - 1) playerRow++ }
    fun moveLeft() { if (playerCol > 0) playerCol-- }
    fun moveRight() { if (playerCol < 9) playerCol++ }

    fun step() {
        if (gameOver) return
        val newCars = mutableListOf<Pair<Int, Int>>()
        for ((r, c) in cars) {
            val nc = (c + 1) % 10
            newCars.add(Pair(r, nc))
        }
        cars.clear(); cars.addAll(newCars)
        // Vérifier collision avec voiture
        if (cars.any { it.second == playerCol && it.first == playerRow }) {
            gameOver = true
        }
        // Vérifier collision avec log (si sur log = sûr)
        val onLog = logs.any { it.second == playerCol && it.first == playerRow }
        if (!onLog && playerRow > 0 && !cars.any { it.second == playerCol && it.first == playerRow }) {
            // Sur l'eau = pas sûr
        }
    }

    fun isCellFilled(col: Int, row: Int): Boolean {
        if (playerCol == col && playerRow == row) return true
        if (cars.any { it.second == col && it.first == row }) return true
        if (logs.any { it.second == col && it.first == row }) return true
        if (row == 0) return true // ligne d'arrivée
        return false
    }
}
