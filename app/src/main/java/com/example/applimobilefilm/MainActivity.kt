package com.example.applimobilefilm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.sp
import com.example.applimobilefilm.components.BottomBar
import com.example.applimobilefilm.components.SearchBarWithIcon
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ApplimobilefilmTheme {
                Scaffold(
                    bottomBar = {
                        BottomBar(onHomeClick = {
                            val intent = Intent(this@MainActivity, MainActivity::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                            startActivity(intent)
                        }, onStarClick = {
                            val intent = Intent(this@MainActivity, GestionActivity::class.java)
                            startActivity(intent)
                        }, onInfoClick = {
                            // Handle Info click
                        })
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    MoviePreviewContent()
                }
            }
        }
    }

    @Composable
    fun MoviePreviewContent() {
        val movieSuggestions = listOf(
            "Titanic", "Avatar", "Inception", "The Dark Knight", "Interstellar",
            "La La Land", "Pulp Fiction", "Fight Club", "The Matrix"
        )

        var filteredSuggestions by remember { mutableStateOf(emptyList<String>()) }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(Color(0xFF511730))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SearchBarWithIcon(
                        modifier = Modifier.fillMaxWidth(),
                        suggestions = filteredSuggestions,
                        onSearchTextChanged = { searchText ->
                            filteredSuggestions = movieSuggestions
                                .filter { it.contains(searchText, ignoreCase = true) }
                        }
                    )
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

    @Composable
    fun ListContent(car1: List<Int>, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .align(Alignment.CenterHorizontally),
                        style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp),
                        text = "Films à venir",
                        color = Color(0xFFE0D68A)
                    )
                    Text(
                        text = "Romance",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier.height(130.dp)
                    ) {
                        LazyRow(
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Wolverine")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Thriller",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier.height(130.dp)
                    ) {
                        LazyRow(
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Superman")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Thriller",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier.height(130.dp)
                    ) {
                        LazyRow(
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Superman")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Thriller",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier.height(130.dp)
                    ) {
                        LazyRow(
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Superman")
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    @Preview(showBackground = true, showSystemUi = true)
    fun MoviePreview() {
        MoviePreviewContent()
    }
}
