package com.nikodindon.retrogame

class AsteroidsEngine {
    val cols = 10
    val rows = 12
    var playerX = 5
    var playerY = 10
    var score = 0
    var gameOver = false
    private val asteroids = mutableListOf<Triple<Int, Int, Int>>()
    private val bullets = mutableListOf<Pair<Int, Int>>()
    val asteroidsPublic: List<Triple<Int, Int, Int>> get() = asteroids.toList()
    val bulletsPublic: List<Pair<Int, Int>> get() = bullets.toList()

    fun reset() {
        playerX = 5; playerY = 10; score = 0; gameOver = false
        asteroids.clear(); bullets.clear()
        for (i in 0..4) asteroids.add(Triple(i * 2 + 1, 2, 2))
    }

    fun moveLeft() { if (playerX > 0) playerX-- }
    fun moveRight() { if (playerX < cols - 1) playerX++ }
    fun shoot() { bullets.add(Pair(playerX, playerY - 1)) }

    fun step() {
        if (gameOver) return
        val newBullets = mutableListOf<Pair<Int, Int>>()
        for ((bx, by) in bullets) if (by > 0) newBullets.add(Pair(bx, by - 1))
        bullets.clear(); bullets.addAll(newBullets)

        // Vérifier collisions
        val hits = mutableListOf<Triple<Int, Int, Int>>()
        for ((bx, by) in bullets) {
            for (a in asteroids) {
                if (bx == a.first && by == a.second) {
                    hits.add(a)
                    score += 20
                }
            }
        }
        asteroids.removeAll(hits)
        if (asteroids.any { it.first == playerX && it.second == playerY }) gameOver = true
    }

    fun isCellFilled(col: Int, row: Int): Boolean {
        if (playerX == col && playerY == row) return true
        if (bullets.any { it.first == col && it.second == row }) return true
        if (asteroids.any { it.first == col && it.second == row }) return true
        return false
    }
}
