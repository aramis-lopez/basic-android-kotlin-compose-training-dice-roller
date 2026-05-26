package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme

// Si tienes la importación de la clase R (import com.example.greetingcard.R), déjala aquí.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // Contenedor principal
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) { GreetingImage(message = "Happy Birthday Aramis!", from = "From Aramis") }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
        Text(text = message, fontSize = 100.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
        Text(
                text = from,
                fontSize = 36.sp,
                modifier = Modifier.padding(16.dp).align(alignment = Alignment.CenterHorizontally)
        )
    }
}

// Nueva función que junta la imagen y el texto
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    // Cargamos la imagen desde la carpeta drawable
    val image = painterResource(R.drawable.imagen1)

    // Box nos permite poner la imagen de fondo y el texto encima
    Box(modifier) {
        Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop, // Mantiene la proporción cortando lo que sobre
                modifier = Modifier.fillMaxSize(), // <-- ¡ESTO ES LO NUEVO! Obliga a la imagen a
                // llenar la pantalla
                alpha = 0.8F // Le subí la opacidad a 0.8 para que los colores del pastel resalten
                // más
                )
        GreetingText(
                message = message,
                from = from,
                modifier = Modifier.fillMaxSize().padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    GreetingCardTheme { GreetingImage(message = "Happy Birthday Aramis!", from = "From Aramis") }
}
