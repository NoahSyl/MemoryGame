package com.example.memorygame.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.memorygame.R
import com.example.memorygame.ui.theme.MemoryGameTheme
import com.example.memorygame.viewModel.ViewModel

@Composable
fun MenuScreen(viewModel: ViewModel) {

    var expanded by remember { mutableStateOf(false) }
    val dificultades = listOf("Easy", "Mid", "Difficult")
    var opcionSeleccionada by remember {
        mutableStateOf(dificultades[0])
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painterResource(
                id = R.drawable.ic_launcher_foreground
            ),
            contentDescription = "Imagen del menú",
            modifier = Modifier
                .padding(top = 80.dp)
                .padding(bottom = 100.dp)
        )

        Column {

            ElevatedButton(
                modifier = Modifier
                    .width(150.dp)
                    .padding(top = 15.dp),
                onClick = { expanded = !expanded })
            {
                Text(text = opcionSeleccionada)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
            ) {

                dificultades.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            expanded = false
                            opcionSeleccionada = item
                        })
                }

            }

        }

        Button(
            modifier = Modifier
                .width(150.dp)
                .padding(top = 15.dp),
            onClick = { /*NAVEGACIÓN*/ }) {

            Text(text = "Play")

        }

        Button(
            modifier = Modifier
                .width(150.dp)
                .padding(top = 15.dp),
            onClick = { /*NAVEGACIÓN*/ }) {

            Text(text = "Help")

        }

    }

}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    MemoryGameTheme {
        MenuScreen(viewModel = ViewModel())
    }
}
