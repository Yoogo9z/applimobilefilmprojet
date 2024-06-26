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
        @SerializedName("Title") val movie: String,
        @SerializedName("Poster") val image: String,
        @SerializedName("Plot") val overview: String,
        @SerializedName("Genre") val genre: String,
        @SerializedName("Country") val country: String,
        @SerializedName("Year") val year: String
    ) {
        val response: Any
            get() {
                TODO()
            }
    }


    data class MoviesResponse(
        val results: List<Movie>
    )

    fun getPopularMovies(onResult: (MoviesResponse?) -> Unit) {
        val request = Request.Builder()
            .url("https://www.omdbapi.com/?i=tt3896198&apikey=3fafb9db?api_key=$apiKey")
            .build()

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                // Handle error
                onResult(null)
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    response.body?.string()?.let { json ->
                        val moviesResponse = gson.fromJson(json, MoviesResponse::class.java)
                        onResult(moviesResponse)
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
