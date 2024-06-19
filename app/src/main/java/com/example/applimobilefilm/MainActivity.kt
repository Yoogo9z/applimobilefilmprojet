package com.example.applimobilefilm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme
//data class ImageWithText(val painter: Painter, val text: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        window.navigationBarColor = Color.Black.toArgb()
        window.statusBarColor = Color.Black.toArgb()
        setContent {
            MoviePreview()
        }
    }

    @Composable
    fun SearchBarWithIcon(modifier: Modifier = Modifier) {
        var textState by remember { mutableStateOf(TextFieldValue("")) }
        Column(
            modifier = modifier
                .fillMaxWidth(),
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = modifier
                        .fillMaxHeight()
                        .background(Color(0xFF320A28))
                        .padding(start = 12.dp, end = 12.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Accueil",
                        color = Color(0xFFE0D68A)

                    )
                    Spacer(modifier = Modifier.width(100.dp))
                    BasicTextField(
                        value = textState,
                        onValueChange = { textState = it },
                        modifier = Modifier
                            .weight(1f)
                            .background(Color(0xFFE0D68A), RoundedCornerShape(8.dp))
                            .padding(vertical = 12.dp, horizontal = 16.dp)
                            .height(20.dp),
                        decorationBox = { innerTextField ->
                            if (textState.text.isEmpty()) {
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
    }

    @Composable
    fun List(car1: List<Painter>, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp),
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(30.dp)
                    )
                    Text(
                        text = "Romance",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LazyRow(
                            modifier = Modifier
                                .padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painter, text = "Wolverine")
                            }
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(30.dp)

                    )

                    Text(
                        text = "Thriller",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LazyRow(
                            modifier = Modifier
                                .padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painter, text = "Superman")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Action",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LazyRow(
                            modifier = Modifier
                                .padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painter, text = "Batman")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Fantastique",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LazyRow(
                            modifier = Modifier
                                .padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painter, text = "Hulk")
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun MoviePreview() {
        ApplimobilefilmTheme {
            Scaffold(
                bottomBar = {
                    BottomAppBar {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFF511730))
                        ) {
                        }
                    }
                },
                modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFF511730))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                        ) {
                            Box(
                                Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                            ) {
                                SearchBarWithIcon()
                            }
                            Spacer(modifier = Modifier.weight(0.1f))
                            List(
                                car1 = listOf(
                                    painterResource(R.drawable.image1),
                                    painterResource(R.drawable.image2),
                                    painterResource(R.drawable.image3),
                                    painterResource(R.drawable.car1)
                                ),
                                modifier = Modifier.weight(8.9f)
                            )
                        }
                    }
                }
            }
        }
    }
}
