package com.example.applimobilefilm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviePreview()
        }
    }

    @Composable
    fun SearchBarWithIcon(modifier: Modifier = Modifier) {
        var textState by remember { mutableStateOf(TextFieldValue("")) }
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = modifier
                        .fillMaxHeight(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Accueil",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(100.dp))
                    BasicTextField(
                        value = textState,
                        onValueChange = { textState = it },
                        modifier = Modifier
                            .weight(1f)
                            .background(Color.LightGray, RoundedCornerShape(8.dp))
                            .padding(vertical = 12.dp, horizontal = 16.dp)
                            .height(20.dp),
                        decorationBox = { innerTextField ->
                            if (textState.text.isEmpty()) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        Icons.Filled.Search,
                                        contentDescription = "Search Icon",
                                        modifier = Modifier.size(16.dp),
                                        tint = Color.Gray
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "Rechercher un film",
                                        color = Color.Gray
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
                ) {
                    Text(
                        text = "Romance",
                        color = Color.White
                    )
                    Row(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()                      ,
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LazyRow(
                            modifier = Modifier
                                .padding(top = 12.dp)
                        ) {
                            items(car1) { image ->
                                Image(
                                    painter = image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .fillMaxHeight()
                                        .width(130.dp)
                                        .clip(RoundedCornerShape(14.dp)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                    Text(
                        text = "Thrillers",
                        color = Color.White
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
                            items(car1) { image ->
                                Image(
                                    painter = image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .fillMaxHeight()
                                        .width(130.dp)
                                        .clip(RoundedCornerShape(14.dp)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                    Text(
                        text = "Action",
                        color = Color.White
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
                            items(car1) { image ->
                                Image(
                                    painter = image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .fillMaxHeight()
                                        .width(130.dp)
                                        .clip(RoundedCornerShape(14.dp)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                    Text(
                        text = "Fantastique",
                        color = Color.White
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
                            items(car1) { image ->
                                Image(
                                    painter = image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .fillMaxHeight()
                                        .width(130.dp)
                                        .clip(RoundedCornerShape(14.dp)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                    Text(
                        text = "Psychologique",
                        color = Color.White
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
                            items(car1) { image ->
                                Image(
                                    painter = image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .fillMaxHeight()
                                        .width(130.dp)
                                        .clip(RoundedCornerShape(14.dp)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Preview(showBackground = true)
    @Composable
    fun MoviePreview() {
        ApplimobilefilmTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
                                .padding(start = 12.dp)
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
