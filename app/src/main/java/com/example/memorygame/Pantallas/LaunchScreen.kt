package com.example.memorygame.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.memorygame.Greeting
import com.example.memorygame.R
import com.example.memorygame.ui.theme.MemoryGameTheme

@Composable
fun LaunchScreen() {

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
            contentDescription = "Imagen principal"
        )

        Text(
            text = "Memory Game",
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp
        )

    }

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    MemoryGameTheme {
        LaunchScreen()
    }
}