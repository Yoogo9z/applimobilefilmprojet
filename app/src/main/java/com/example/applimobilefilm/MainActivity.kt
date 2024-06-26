package com.example.applimobilefilm

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applimobilefilm.api.MovieApiClient
import com.example.applimobilefilm.components.BottomBar
import com.example.applimobilefilm.components.SearchBarWithIcon
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

class MainActivity : AppCompatActivity() {

	private val apiKey = "3fafb9db"
	private lateinit var movieApiClient: MovieApiClient
	private val movies = mutableStateOf(emptyList<MovieApiClient.Movie>())

	@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val policy = ThreadPolicy.Builder().permitAll().build()
		StrictMode.setThreadPolicy(policy)

		enableEdgeToEdge()

		movieApiClient = MovieApiClient(apiKey)

		fetchMovies()

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
						}, navController = navController
						)
					}, modifier = Modifier.fillMaxSize()
				) {
					NavHost(navController = navController, startDestination = "home") {
						composable("home") {
							MoviePreviewContent(movies = movies.value)
						}
						composable("favoris") {
							MoviePreviewContentFav({}, {})
						}
						composable("details") {
							MoviePreviewD()
						}
					}
				}
			}
		}
	}

	private fun fetchMovies() {
		val client = OkHttpClient()
		val movieIds = listOf(
			"tt0111161", "tt0068646", "tt0468569", "tt0110912", "tt0109830", "tt1375666",
			"tt0071562", "tt0137523", "tt0120737", "tt0088763", "tt0167260", "tt0110357",
			"tt0110413", "tt0108052", "tt0167261", "tt0133093", "tt0114814", "tt0245429",
			"tt0120815", "tt0112573", "tt0038650", "tt0120586", "tt0120689", "tt0099685"
		)

		val moviesList = mutableListOf<MovieApiClient.Movie>()

		movieIds.forEach { movieId ->
			val request = Request.Builder()
				.url("https://www.omdbapi.com/?i=$movieId&apikey=$apiKey")
				.build()

			client.newCall(request).enqueue(object : okhttp3.Callback {
				override fun onFailure(call: okhttp3.Call, e: IOException) {
					e.printStackTrace()
				}

				override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
					response.use {
						if (!it.isSuccessful) throw IOException("Unexpected code $response")

						val responseBody = it.body!!.string()
						val movie = Gson().fromJson(responseBody, MovieApiClient.Movie::class.java)
						runOnUiThread {
							moviesList.add(movie)
							if (moviesList.size == movieIds.size) {
								movies.value = moviesList
							}
						}
					}
				}
			})
		}
	}

	@Composable
	fun MoviePreviewContent(movies: List<MovieApiClient.Movie>) {
		val movieSuggestions = listOf(
			"Titanic", "Avatar", "Inception", "The Dark Knight", "Interstellar",
			"La La Land", "Pulp Fiction", "Fight Club", "The Matrix"
		)
		var filteredSuggestions by remember { mutableStateOf(emptyList<String>()) }

		Column(
			modifier = Modifier.fillMaxSize()
		) {
			SearchBarWithIcon(
				modifier = Modifier
					.fillMaxWidth()
					.weight(1f),
				suggestions = filteredSuggestions,
				onSearchTextChanged = { searchText ->
					filteredSuggestions = movieSuggestions.filter {
						it.contains(
							searchText,
							ignoreCase = true
						)
					}
				}
			)
			Box(
				modifier = Modifier
					.weight(8f)
					.fillMaxHeight()
					.fillMaxWidth()
					.background(Color(0xFF511730))
			) {
				ListContent(movies = movies)
			}
		}
	}

//	@Composable
//	fun MovieList(movies: List<MovieApiClient.Movie>) {
//		LazyColumn(
//			modifier = Modifier
//				.fillMaxWidth()
//				.background(Color(0xFF511730))
//		) {
//			items(movies) { movie ->
//				ImageScroll(imageUrl = movie.image, text = movie.movie)
//			}
//		}
//	}

	@Composable
	fun ListContent(movies: List<MovieApiClient.Movie>, modifier: Modifier = Modifier) {
		val genres = movies.groupBy { it.genre }
		val limitedGenres = genres.keys.take(3)

		LazyColumn(
			modifier = modifier.fillMaxSize()
		) {
			limitedGenres.forEach { genre ->
				val moviesByGenre = genres[genre]?.let { movies ->
					if (movies.size >= 5) {
						movies.take(5)
					} else {
						movies + List(5 - movies.size) { MovieApiClient.Movie("", "", "", "") }
					}
				} ?: emptyList()
				item {
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
							text = genre,
							color = Color(0xFFE0D68A)
						)
						Row(
							modifier = Modifier.height(130.dp)
						) {
							LazyRow(
								modifier = Modifier.padding(top = 12.dp)
							) {
								items(moviesByGenre) { movie ->
									ImageScroll(imageUrl = movie.image, text = movie.movie)
								}
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
		MoviePreviewContent(movies = emptyList())
	}
}
