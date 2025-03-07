package com.example.prueba

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns
import com.example.prueba.ui.theme.PruebaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //Constructor de la clase padre
        setContent { //Se llama a la funcion UIPrincipal para mostrar la interfaz
            setContent{ UIPrincipal()}
        }
    }
}




@Composable
fun UIPrincipal() {
    val contexto = LocalContext.current
    var nombre by rememberSaveable { mutableStateOf("") }

    // Aplicamos padding a la columna principal (actúa como margen)
    Column(
        modifier = Modifier
            .padding(16.dp) // margen exterior alrededor de toda la columna
    ) {

        Text(
            text = "Nombre: ",
            modifier = Modifier.padding(bottom = 8.dp) // espacio debajo del texto
        )

        OutlinedTextField(
            singleLine = true,
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Introduce tu nombre") },
            modifier = Modifier
                .padding(bottom = 16.dp) // espacio debajo del campo
        )

        Button(
            onClick = {
                Toast.makeText(contexto, "Hola $nombre", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.padding(top = 8.dp) // espacio encima del botón
        ) {
            Text("Saludar!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion() {
    UIPrincipal()
}