package com.example.memorygame.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    var model by mutableStateOf(
        Model(
            dificultad = listOf("Fácil", "Medio", "Difícil"),
            movimientos = 0,
            pausa = false,
            resultado = 0,
            tiempo = 0.0
        )
    )
        private set

    val dificultad = model.dificultad

}