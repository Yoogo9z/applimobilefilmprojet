package com.example.applimobilefilm.api

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MovieApiClient(private val apiKey: String) {

	private val client = OkHttpClient()
	private val gson = Gson()

	data class Movie(
		@SerializedName("Title") val title: String,
		@SerializedName("Year") val year: String,
		@SerializedName("Runtime") val runtime: String,
		@SerializedName("Plot") val plot: String,
		@SerializedName("Poster") val poster: String,
		@SerializedName("imdbRating") val imdbRating: String,
		@SerializedName("Genre") val genre: String,
		@SerializedName("Actors") val actors: String
	)

	fun getMovieDetails(movieId: String, onResult: (Movie?) -> Unit) {
		val request = Request.Builder()
			.url("https://www.omdbapi.com/?i=$movieId&apikey=$apiKey")
			.build()

		client.newCall(request).enqueue(object : okhttp3.Callback {
			override fun onFailure(call: okhttp3.Call, e: IOException) {
				// Handle error
				onResult(null)
			}

			override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
				if (response.isSuccessful) {
					response.body?.string()?.let { json ->
						val movie = gson.fromJson(json, Movie::class.java)
						onResult(movie)
					}
				} else {
					// Handle error
					onResult(null)
				}
				response.close()
			}
		})
	}
}
