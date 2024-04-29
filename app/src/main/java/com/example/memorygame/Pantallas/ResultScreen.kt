package com.example.memorygame.Pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memorygame.ui.theme.MemoryGameTheme

@Composable
fun ResultScreen() {


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Text(
            "Score:",
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            "X points",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            modifier = Modifier
                .width(150.dp)
                .padding(top = 45.dp),
            onClick = { /*NAVEGACIÓN*/ }) {

            Text(text = "Play again")

        }

        Button(
            modifier = Modifier
                .width(150.dp)
                .padding(top = 15.dp),
            onClick = { /*NAVEGACIÓN*/ }) {

            Text(text = "Menu")

        }
    }


}


    @Preview(showBackground = true)
    @Composable
    fun Preview4() {
        MemoryGameTheme {
            ResultScreen()
        }
    }