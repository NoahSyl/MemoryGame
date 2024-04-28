package com.example.memorygame.viewModel

data class Model(
    val dificultad: List<String> = listOf("", "", ""),
    val tiempo: Double,
    val pausa: Boolean,
    val resultado: Int,
    val movimientos: Int


)
