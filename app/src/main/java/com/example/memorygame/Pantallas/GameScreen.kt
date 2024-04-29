import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import com.example.memorygame.R
import com.example.memorygame.ui.theme.MemoryGameTheme

@Composable
fun GameScreen() {
    val tokenList = listOf(
        R.drawable.memory1,
        R.drawable.memory2,
        R.drawable.memory3,
        R.drawable.memory4,
        R.drawable.memory5,
    )

    // Crear 5 pares de imágenes y mezclarlas
    val shuffledTokens = remember { (tokenList + tokenList).shuffled() }

    // Estado para las cartas seleccionadas
    var selectedCards by remember { mutableStateOf<List<Int>>(emptyList()) }

    // Estado para rastrear las coincidencias
    var matchedCards by remember { mutableStateOf(emptyList<Int>()) }

    // Contador de movimientos
    var moveCount by remember { mutableStateOf(0) }

    // Pantalla principal del juego
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Row (
            horizontalArrangement = Arrangement.Absolute.Center,
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        ) {

            Text(
                modifier = Modifier
                    .weight(0.8f)
                    .padding(start = 150.dp),
                text = "00.00",
                fontSize = 35.sp)

            IconButton(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(end = 0.dp),
                onClick = { /*TODO*/ }) {

                Icon(
                   Icons.Rounded.PlayArrow,
                    contentDescription = "Pausa" )
                
            }

        }

        // Mostrar las cartas en una cuadrícula dinámica
        LazyColumn(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(5) { item -> //creamos la columna
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    //bucle que crea las cards donde metemos los tokens
                    //lo paramos cuando llegue a 2 con until
                    for (indiceCol in 0 until 2) {
                        //buscamos el item en las columnas
                        //indiceCol es 0 o 1, una columna u otra
                        //indiceItem multiplica el item x 2 y suma el indice de columna
                        //si item es 0 y el indice de columna es 0 -> 0*2+0=0 -> 0.0 es la posición
                        val indiceItem = item * 2 + indiceCol
                        //creamos una card donde meteremos el placeholder o la imagen
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .clickable {
                                    //cada vez que cliquemos subimos el contador
                                    moveCount++
                                    //si se han seleccionado menos de dos cartas
                                    //y la carta no está ya emparejada -> se añade a selectedcard
                                    //selectedCard es una nueva lista que la posición del item seleccionado
                                    if (selectedCards.size < 2 && !matchedCards.contains(indiceItem)) {
                                        selectedCards = selectedCards + indiceItem
                                    }
                                },
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            //si el indice coincide con la lista de cartas seleccionadas
                            //o con la lista de cartas ya emparejadas
                            //muestra la imagen que pertenece a ese índice
                            if (selectedCards.contains(indiceItem) || matchedCards.contains(indiceItem)) {
                                Image(
                                    painter = painterResource(shuffledTokens[indiceItem]),
                                    contentDescription = null,
                                    modifier = Modifier.size(120.dp),

                                )
                                //si no es así, se convierte en una box con ?
                            } else {
                                Box(
                                    modifier = Modifier.size(120.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("?", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }
        }

        // Comparar las cartas seleccionadas
        //Cada vez que el estado de SelectedCards cambia lanzamos un efecto
        //si la lista es = 2 -> tiene dos cartas
        //comparamos las dos cartas buscando con el indice en la lista de cartas seleccionadas (solo hay 2)
        //si coinciden las añadimos a la lista de parejas
        //limpiamos la lista de cartas seleccionadas
        LaunchedEffect(selectedCards) {
            if (selectedCards.size == 2) {
                delay(1000) // Esperar 1 segundo para mostrar la selección
                if (shuffledTokens[selectedCards[0]] == shuffledTokens[selectedCards[1]]) {
                    matchedCards = matchedCards + selectedCards
                }
                selectedCards = emptyList() // Reiniciar la selección

            }
        }

        Text(
            text = "MOVEMENTS: $moveCount",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    MemoryGameTheme {
        GameScreen()
    }
}
