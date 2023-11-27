package com.catata.dragonball_navigation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.catata.p2dragonball.R


// Cabecera con la imagen del usuario y su nombre
@Composable
fun InfoDialog() {
    Row(
//        modifier = Modifier.fillMaxWidth(),
        modifier = Modifier
            .border(
                width = 4.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(
            20.dp,
            Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Image(
            painter = painterResource(id = R.drawable.rick),
            contentDescription = "Foto de Rick",
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    width = 3.dp,
                    color = colorResource(id = R.color.orange),
                    shape = CircleShape
                )
                .width(80.dp)
        )
        Text(
            text = "Rick Sanchez",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}