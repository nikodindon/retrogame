package com.nikodindon.retrogame

data class Piece(var type: PieceType, var rotation: Int = 0, var x: Int = 3, var y: Int = 0) {
    val cells: List<Pair<Int, Int>>
        get() = SHAPES[type]!!.getOrElse(rotation % 4) { SHAPES[type]!!.first() }
}

class GameEngine {
    val cols = 10
    val rows = 20
    private var grid = Array(rows) { BooleanArray(cols) { false } }
    var current: Piece? = null
    var nextType: PieceType? = null
    var score = 0
    var lines = 0
    var level = 1
    var gameOver = false
    private val bag = mutableListOf<PieceType>()

    init {
        bag.addAll(PieceType.values().asList())
    }

    fun reset() {
        grid = Array(rows) { BooleanArray(cols) { false } }
        score = 0; lines = 0; level = 1; gameOver = false
        bag.clear(); bag.addAll(PieceType.values().asList()); bag.shuffle()
        nextType = drawFromBag()
        spawn()
    }

    private fun drawFromBag(): PieceType {
        if (bag.isEmpty()) { bag.addAll(PieceType.values().asList()); bag.shuffle() }
        return bag.removeAt(0)
    }

    fun spawn() {
        val type = nextType ?: drawFromBag()
        nextType = drawFromBag()
        current = Piece(type, 0, 3, 0)
        if (hasCollision(current!!)) { gameOver = true }
    }

    fun step(): Boolean {
        if (gameOver) return false
        val moved = current!!.copy(y = current!!.y + 1)
        if (hasCollision(moved)) {
            lock()
            return true
        } else {
            current = moved
            return false
        }
    }

    fun moveLeft()  { current?.let { val m = it.copy(x = it.x - 1); if (!hasCollision(m)) current = m } }
    fun moveRight() { current?.let { val m = it.copy(x = it.x + 1); if (!hasCollision(m)) current = m } }
    fun rotate()    { current?.let { val r = it.copy(rotation = it.rotation + 1); if (!hasCollision(r)) current = r } }

    fun hardDrop() {
        if (gameOver) return
        var moved = current!!.copy()
        while (!hasCollision(moved.copy(y = moved.y + 1))) {
            moved = moved.copy(y = moved.y + 1)
        }
        current = moved
        lock()
    }

    private fun hasCollision(p: Piece): Boolean {
        for ((dx, dy) in p.cells) {
            val cx = p.x + dx
            val cy = p.y + dy
            if (cx < 0 || cx >= cols || cy >= rows) return true
            if (cy >= 0 && grid[cy][cx]) return true
        }
        return false
    }

    private fun lock() {
        val p = current ?: return
        for ((dx, dy) in p.cells) {
            val cx = p.x + dx; val cy = p.y + dy
            if (cy >= 0 && cy < rows && cx >= 0 && cx < cols) grid[cy][cx] = true
        }
        clearLines()
        spawn()
    }

    private fun clearLines() {
        var cleared = 0
        for (r in rows - 1 downTo 0) {
            if (grid[r].all { it }) {
                for (rr in r downTo 1) grid[rr] = grid[rr - 1].clone()
                grid[0] = BooleanArray(cols) { false }
                cleared++
            }
        }
        lines += cleared
        score += when (cleared) {
            1 -> 100
            2 -> 300
            3 -> 500
            4 -> 800
            else -> 0
        } * level
        level = 1 + lines / 10
    }

    fun getCell(col: Int, row: Int): Boolean = if (row in 0 until rows && col in 0 until cols) grid[row][col] else false
    fun getGridSnapshot(): Array<BooleanArray> = Array(rows) { grid[it].clone() }
}
