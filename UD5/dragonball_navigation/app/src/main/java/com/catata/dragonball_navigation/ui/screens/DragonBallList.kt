package com.catata.dragonball_navigation.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import com.catata.dragonball_navigation.model.Character
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// Componente propio para mostrar una lista de personajes, implementa StateHoisting para informar sobre el personaje que se haga clic
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DragonBallList(
    modifier: Modifier = Modifier,
    value: Int,
    onValueChange: (Int) -> Unit
) {
    // Se usa un LazyColumn para que se gestione automáticamente el scroll
    LazyColumn(modifier = modifier) {
        // El LazyColumn tiene StickyHeaders así que se usa la función sorted()d e Character para obtener
        //  un Map con la primera letra del personaje y una lista de Personajes que empiezan por esa letra
        val groupedCharacter: Map<Char, List<Character>> = Character.sorted().groupBy { it.spanishName[0] }
        groupedCharacter.forEach { (header, characters) ->
            stickyHeader {
                CharactersLettersHeader(header)
                Divider(
                    color = MaterialTheme.colorScheme.primary,
                    thickness = 1.dp
                )
            }
            items(characters) {
                // Cuando se añaden los personajes si coincide con el seleccionado se indica con el parámetro selected a true
                CharacterItem(
                    item = it,
                    onClick = {
                        onValueChange(it.id)
                    },
                    selected = it.id == value
                )
            }
        }

    }
}

// Componente propio para las letras de los Stickyheaders
@Composable
fun CharactersLettersHeader(header: Char) {
    Text(
        text = header.toString(),
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
    )
}

// Componente propio para los nombres de los personajes en la lista
//  Implementa StateHoisting para poder informar al padre cuando se hace clic en un elemento
@Composable
fun CharacterItem(
    item: Character,
    onClick: () -> Unit,
    selected: Boolean
) {
    Row(
        modifier = Modifier
            .clickable(
                onClick = onClick
            )
            .background(
                if (selected) {
                    MaterialTheme.colorScheme.tertiaryContainer
                } else {
                    MaterialTheme.colorScheme.background
                }
            )
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                bottom = 8.dp,
                start = 16.dp
            )
    ) {
        if (selected) {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "Seleccionado"
            )
        }
        Text(
            text = item.spanishName,
            fontSize = 18.sp,

            )
    }
}