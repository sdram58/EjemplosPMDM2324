package com.catata.dragonball_navigation.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.catata.dragonball_navigation.model.Character


// Componente propio para mostrar la información de un personaje
//  Recibe el estado del scroll para que se pueda modificar desde fuera de este componente
@Composable
fun CharacterDetail(
        modifier: Modifier = Modifier,
        scrollState: LazyListState,
        characterId: Int = 0
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
                .then(modifier)
        ) {
            // Si no se ha seleccionado aún un personaje se indicará mensaje con una Card
            if (characterId == 0) {
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    shape = CutCornerShape(16.dp),
                    border = BorderStroke(width = 4.dp, brush = Brush.linearGradient(listOf(Color(0xFFFDD835), Color(0xFFFB8C00), Color(0xFFE53935)))),
                    modifier = Modifier
                        .fillMaxSize()
                        .then(modifier)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            imageVector = Icons.Default.WarningAmber,
                            contentDescription = "Advertencia",
                            tint = Color(0xFFFB8C00),
                            modifier = Modifier.size(48.dp)
                        )
                        Text(
                            text = "Selecciona un personaje de la lista de la izquierda",
                            fontSize = 40.sp,
                            lineHeight = 50.sp,
                            textAlign = TextAlign.Center
                        )
                        Icon(
                            imageVector = Icons.Default.WarningAmber,
                            contentDescription = "Advertencia",
                            tint = Color(0xFFFB8C00),
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
            } else {
                // Si hay un personaje seleccionado se recupera usando la data class Character
                val character = Character.getCharacterById(characterId)
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = character.spanishName,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            text = "(${character.japaneseName})",
                            fontSize = 24.sp
                        )
                    }
                    Divider(
                        color = MaterialTheme.colorScheme.secondary,
                        thickness = 2.dp
                    )
                    // Para mostrar el resto de información se utiliza un LazyColumn cuyo state (scroll)
                    //  se recibe desde fuera ya que desde fuera se reseteará el scroll cuando se cambie de personaje
                    LazyColumn(
                        state = scrollState
                    ) {
                        item {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                // Se carga la imagen con la librería Coil
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(character.photo)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "Foto de ${character.spanishName}",
                                    modifier = Modifier
                                        .weight(3f)
                                        .height(170.dp)
                                        .padding(top = 4.dp, end = 10.dp, bottom = 4.dp)
                                )
                                Column(
                                    modifier = Modifier.weight(7f)
                                ) {
                                    // Se ha creado un componente propio para los siguientes datos para que tengan todos el mismo estilo
                                    DataInfo(
                                        title = "Año de nacimiento",
                                        info = if (character.birthdayYear != 0) character.birthdayYear.toString() else "desconocido"
                                    )
                                    DataInfo(
                                        title = "Género",
                                        info = character.gender
                                    )
                                    DataInfo(
                                        title = "Otros nombres",
                                        info = if (character.otherName.isNotEmpty()) character.otherName else "desconocidos"
                                    )
                                    DataInfo(
                                        title = "Especie",
                                        info = character.species
                                    )
                                }
                            }
                        }
                        item {
                            Text(
                                text = "INFORMACIÓN",
                                fontSize = 30.sp
                            )
                        }
                        item {
                            Text(text = character.information)
                        }
                    }
                }
            }
        }
    }

    // Componente propio para mostrat algunos datos del personaje
    @Composable
    fun DataInfo(title: String, info: String) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$title:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .weight(1f)
            )
            Text(
                text = info,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .weight(1f)
            )
        }
    }