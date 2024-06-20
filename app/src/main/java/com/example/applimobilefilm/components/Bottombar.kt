package com.example.applimobilefilm.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BottomBar(onHomeClick: () -> Unit, onStarClick: () -> Unit, onInfoClick: () -> Unit) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xFF3D1752)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onHomeClick,
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Filled.Home, contentDescription = "Home Icon", tint = Color(0xFFE0D68A))
            }
            IconButton(
                onClick = onStarClick,
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Filled.Star, contentDescription = "Star Icon", tint = Color(0xFFE0D68A))
            }
            IconButton(
                onClick = onInfoClick,
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Filled.Info, contentDescription = "Info Icon", tint = Color(0xFFE0D68A))
            }
        }
    }
}
