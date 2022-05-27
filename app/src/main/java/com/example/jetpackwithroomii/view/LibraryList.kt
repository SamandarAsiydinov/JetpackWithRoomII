package com.example.jetpackwithroomii.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackwithroomii.database.Library

@Composable
fun LibraryList(library: Library) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(15.dp)
    ) {
        Text(
            text = library.id.toString(),
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = library.title,
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}