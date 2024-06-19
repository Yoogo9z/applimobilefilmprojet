package com.example.applimobilefilm.components

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BottomBar() {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xFF3D1752)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceAround,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Action à effectuer pour Home */ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Filled.Home, contentDescription = "Home Icon", tint = Color(0xFFE0D68A))
            }
            IconButton(
                onClick = { /* Action à effectuer pour Star */ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Filled.Star, contentDescription = "Star Icon", tint = Color(0xFFE0D68A))
            }
            IconButton(
                onClick = { /* Action à effectuer pour Info */ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Filled.Info, contentDescription = "Info Icon", tint = Color(0xFFE0D68A))
            }
        }
    }
}
