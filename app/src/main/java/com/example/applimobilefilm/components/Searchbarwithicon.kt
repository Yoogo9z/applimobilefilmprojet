package com.example.applimobilefilm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBarWithIcon(
    modifier: Modifier = Modifier,
    suggestions: List<String> = emptyList(),
    onSearchTextChanged: (String) -> Unit

) {
    var textState by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color(0xFF320A28))
                    .padding(start = 12.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Accueil",
                    color = Color(0xFFE0D68A)
                )
                Spacer(modifier = Modifier.width(100.dp))
                BasicTextField(
                    value = textState,
                    onValueChange = {
                        textState = it
                        onSearchTextChanged(it)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFE0D68A), RoundedCornerShape(8.dp))
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                        .height(20.dp),
                    decorationBox = { innerTextField ->
                        if (textState.isEmpty()) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Filled.Search,
                                    contentDescription = "Search Icon",
                                    modifier = Modifier.size(16.dp),
                                    tint = Color.Black.copy(alpha = 0.6f)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Rechercher un film",
                                    color = Color.Black.copy(alpha = 0.6f)
                                )
                            }
                        } else {
                            innerTextField()
                        }
                    }
                )
            }
        }
    }


    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(suggestions) { suggestion ->
            Text(
                text = suggestion,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp)
                    .clickable {
                        // Action à effectuer lorsqu'une suggestion est sélectionnée
                        // Par exemple : naviguer vers les détails du film associé à la suggestion
                    },
                style = TextStyle(
                    color = Color.White, // Change the color here
                    fontSize = 18.sp,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    letterSpacing = 1.sp
                ),
                textAlign = TextAlign.Center // Change the alignment here
            )
        }
    }
}