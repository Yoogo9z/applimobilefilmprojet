package com.example.applimobilefilm

//import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applimobilefilm.components.BottomBar
import com.example.applimobilefilm.components.SearchBarWithIcon
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme

class MainActivity : AppCompatActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplimobilefilmTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomBar(onHomeClick = {
                            navController.navigate("home")
                        }, onStarClick = {
                            navController.navigate("favoris")
                        }, onInfoClick = {
                            navController.navigate("details")
                        },
                            navController = navController
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { MoviePreviewContent() }
                        composable("favoris") { MoviePreviewContentFav({}, {}) }
                        composable("details") { MoviePreviewD() }
                    }
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1.5f),
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
                        text = "Fantastique",
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
    @Preview(showBackground = true)
    fun MoviePreview() {
        MoviePreviewContent()
    }
}
