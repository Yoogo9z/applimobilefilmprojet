package com.example.applimobilefilm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applimobilefilm.components.BottomBar
import com.example.applimobilefilm.components.SearchBarWithIcon
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme
//data class ImageWithText(val painter: Painter, val text: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MoviePreview()
        }
    }

    @Composable
    fun ListContent(car1: List<Int>, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxWidth()
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
                        modifier = Modifier.height(30.dp)
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
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Wolverine")
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
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Superman")
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
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Batman")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
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
                bottomBar = { BottomBar() },
                modifier = Modifier.fillMaxSize()
            ){ innerPadding ->
                Column(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF511730))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                        ) {
                            Box(
                                Modifier
                                    .weight(1.5f)
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                            ) {
                                SearchBarWithIcon()
                            }
                            Spacer(modifier = Modifier.weight(0.1f))
                            ListContent(
                                car1 = listOf(
                                    R.drawable.image1,
                                    R.drawable.image2,
                                    R.drawable.image3,
                                    R.drawable.car1
                                ),
                                modifier = Modifier.weight(8.4f)
                            )
                        }
                    }
                }
            }
        }
    }
}
