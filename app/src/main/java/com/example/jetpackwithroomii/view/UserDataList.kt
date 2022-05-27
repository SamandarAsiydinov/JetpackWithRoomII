package com.example.jetpackwithroomii.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackwithroomii.database.UserAndLibrary

@Composable
fun UserDataList(userAndLibrary: UserAndLibrary) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightGray)
            .padding(15.dp)
    ) {
        Text(
            text = userAndLibrary.user.userId.toString(),
            modifier = Modifier.weight(0.3f),
            color = Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = userAndLibrary.user.name,
            modifier = Modifier.weight(0.3f),
            color = Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = userAndLibrary.user.age.toString(),
            modifier = Modifier.weight(0.3f),
            color = Black,
            fontWeight = FontWeight.Bold
        )
    }
}