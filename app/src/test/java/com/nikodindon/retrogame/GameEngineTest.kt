package com.nikodindon.retrogame

import org.junit.Assert.*
import org.junit.Test

class GameEngineTest {
    @Test
    fun testResetAndSpawn() {
        val engine = GameEngine()
        engine.reset()
        assertTrue(engine.current != null)
        assertFalse(engine.gameOver)
    }

    @Test
    fun testScoreIncreases() {
        val engine = GameEngine()
        engine.reset()
        val initialScore = engine.score
        engine.step()
        assertTrue(engine.score >= initialScore)
    }

    @Test
    fun testSevenPieceTypes() {
        val types = PieceType.values()
        assertEquals(7, types.size)
    }
}
