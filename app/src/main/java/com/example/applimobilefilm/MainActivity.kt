package com.example.applimobilefilm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applimobilefilm.components.BottomBar
import com.example.applimobilefilm.domaine.model.Movie
import com.example.applimobilefilm.repository.MovieRepository
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme
import com.example.applimobilefilm.viewmodel.MovieViewModel

class MainActivity : ComponentActivity() {

    private val movieRepository = MovieRepository()
    private lateinit var viewModel: MovieViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MovieViewModel::class.java)

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
                        composable("home") { MoviePreviewContent(viewModel) }
                        composable("favoris") { MoviePreviewContentFav({}, {}) }
                        composable("details") { MoviePreviewD() }
                    }
                }
            }
        }
    }

    @Composable
    fun MoviePreviewContent(viewModel: MovieViewModel = viewModel()) {
        var movies by remember { mutableStateOf<List<Movie>>(emptyList()) }
        var errorMessage by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            viewModel.fetchMovies("YOUR_API_KEY_HERE")
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (movies.isEmpty() && errorMessage.isEmpty()) {
                Text(text = "Loading...")
            } else if (errorMessage.isNotEmpty()) {
                Text(text = "Error: $errorMessage")
            } else {
                MovieListContent(movies = movies)
            }
        }
    }

    @Composable
    fun MovieListContent(movies: List<Movie>) {
        LazyColumn {
            items(movies) { movie ->
                MovieItem(movie = movie)
            }
        }
    }

    @Composable
    fun MovieItem(movie: Movie) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = movie.title)
            Text(text = "Rating: ${movie.vote_average}")
            Text(text = movie.overview)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MoviePreview() {
        MoviePreviewContent()
    }
}
