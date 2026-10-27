package com.nikodindon.retrogame

enum class PieceType { I, O, T, S, Z, J, L }

val SHAPES: Map<PieceType, List<List<Pair<Int, Int>>>> = mapOf(
    PieceType.I to listOf(
        listOf(Pair(0,1), Pair(1,1), Pair(2,1), Pair(3,1)),
        listOf(Pair(2,0), Pair(2,1), Pair(2,2), Pair(2,3)),
        listOf(Pair(0,1), Pair(1,1), Pair(2,1), Pair(3,1)),
        listOf(Pair(2,0), Pair(2,1), Pair(2,2), Pair(2,3))
    ),
    PieceType.O to listOf(
        listOf(Pair(1,0), Pair(2,0), Pair(1,1), Pair(2,1)),
        listOf(Pair(1,0), Pair(2,0), Pair(1,1), Pair(2,1)),
        listOf(Pair(1,0), Pair(2,0), Pair(1,1), Pair(2,1)),
        listOf(Pair(1,0), Pair(2,0), Pair(1,1), Pair(2,1))
    ),
    PieceType.T to listOf(
        listOf(Pair(1,0), Pair(0,1), Pair(1,1), Pair(2,1)),
        listOf(Pair(1,0), Pair(1,1), Pair(1,2), Pair(2,1)),
        listOf(Pair(0,1), Pair(1,1), Pair(2,1), Pair(1,2)),
        listOf(Pair(1,0), Pair(0,1), Pair(1,1), Pair(1,2))
    ),
    PieceType.S to listOf(
        listOf(Pair(1,0), Pair(2,0), Pair(0,1), Pair(1,1)),
        listOf(Pair(0,1), Pair(1,1), Pair(1,2), Pair(2,2)),
        listOf(Pair(1,0), Pair(2,0), Pair(0,1), Pair(1,1)),
        listOf(Pair(0,1), Pair(1,1), Pair(1,2), Pair(2,2))
    ),
    PieceType.Z to listOf(
        listOf(Pair(0,0), Pair(1,0), Pair(1,1), Pair(2,1)),
        listOf(Pair(1,0), Pair(2,0), Pair(1,1), Pair(0,2)),
        listOf(Pair(0,0), Pair(1,0), Pair(1,1), Pair(2,1)),
        listOf(Pair(1,0), Pair(2,0), Pair(1,1), Pair(0,2))
    ),
    PieceType.J to listOf(
        listOf(Pair(0,0), Pair(0,1), Pair(1,1), Pair(2,1)),
        listOf(Pair(1,0), Pair(2,0), Pair(1,1), Pair(1,2)),
        listOf(Pair(2,0), Pair(1,1), Pair(2,1), Pair(0,1)),
        listOf(Pair(1,0), Pair(1,1), Pair(1,2), Pair(2,2))
    ),
    PieceType.L to listOf(
        listOf(Pair(2,0), Pair(0,1), Pair(1,1), Pair(2,1)),
        listOf(Pair(1,0), Pair(1,1), Pair(1,2), Pair(2,2)),
        listOf(Pair(0,0), Pair(1,0), Pair(1,1), Pair(2,1)),
        listOf(Pair(2,0), Pair(1,0), Pair(1,1), Pair(1,2))
    )
)
