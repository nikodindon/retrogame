package com.nikodindon.retrogame

class SpaceInvadersEngine {
    val cols = 10
    val rows = 15
    var playerX = 5
    var score = 0
    var gameOver = false
    private val enemies = mutableListOf<Pair<Int, Int>>()
    private val bullets = mutableListOf<Pair<Int, Int>>()

    fun reset() {
        playerX = 5
        score = 0
        gameOver = false
        enemies.clear()
        bullets.clear()
        for (r in 0..2) {
            for (c in 2..7) {
                enemies.add(Pair(c, r))
            }
        }
    }

    fun moveLeft() { if (playerX > 0) playerX-- }
    fun moveRight() { if (playerX < cols - 1) playerX++ }
    fun shoot() {
        bullets.add(Pair(playerX, rows - 2))
    }

    fun step() {
        if (gameOver) return
        // Déplacer balles vers le haut
        val newBullets = mutableListOf<Pair<Int, Int>>()
        for ((bx, by) in bullets) {
            if (by > 0) newBullets.add(Pair(bx, by - 1))
        }
        bullets.clear()
        bullets.addAll(newBullets)

        // Vérifier collisions
        val hit = mutableListOf<Pair<Int, Int>>()
        for ((bx, by) in bullets) {
            for (e in enemies) {
                if (bx == e.first && by == e.second) {
                    hit.add(e)
                    score += 50
                }
            }
        }
        enemies.removeAll(hit)

        // Descendre ennemis
        val moved = mutableListOf<Pair<Int, Int>>()
        for ((ex, ey) in enemies) {
            if (ey < rows - 1) moved.add(Pair(ex, ey + 1))
        }
        enemies.clear()
        enemies.addAll(moved)

        if (enemies.any { it.second >= rows - 1 }) gameOver = true
    }

    fun isCellFilled(col: Int, row: Int): Boolean {
        if (playerX == col && row == rows - 1) return true
        if (bullets.any { (bx, by) -> bx == col && by == row }) return true
        if (enemies.any { (ex, ey) -> ex == col && ey == row }) return true
        return false
    }
}
