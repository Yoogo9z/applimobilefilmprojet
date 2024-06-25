package com.example.applimobilefilm.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MovieApiClient(private val apiKey: String) {

    private val client = OkHttpClient()
    private val gson = Gson()

    data class MoviesResponse(
        val movies: List<Movie>,
        val total: Int
    )

    data class Movie(
        val id: Int,
        val movie: String,
        val rating: Float,
        val image: String,
        val imdbUrl: String
    )

    fun getPopularMovies(onResult: (MoviesResponse?) -> Unit) {
        val request = Request.Builder()
            .url("https://dummyapi.online/api/movies?api_key=$apiKey")
            .build()

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                // Handle error
                // You can log the error or take other appropriate action
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
                    // You can log the error or take other appropriate action
                    onResult(null)
                }
                response.close()
            }
        })

    }
}
