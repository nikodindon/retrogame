package com.nikodindon.retrogame

import android.content.Context
import android.content.SharedPreferences

object ScoreStorage {
    private const val PREFS = "retrogame_prefs"
    private const val KEY_BEST = "best_score"

    fun saveBest(context: Context, score: Int) {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val current = prefs.getInt(KEY_BEST, 0)
        if (score > current) prefs.edit().putInt(KEY_BEST, score).apply()
    }

    fun loadBest(context: Context): Int {
        return context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getInt(KEY_BEST, 0)
    }
}
