package com.example.applimobilefilm.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

class MovieRepository(private val apiKey: String) {

    private val client = OkHttpClient()
    private val gson = Gson()

    fun getMovieByTitle(title: String): MovieApiClient.Movie? {
        val url = "http://www.omdbapi.com/?t=${title.replace(" ", "+")}&apikey=$apiKey"
        val request = Request.Builder().url(url).build()

        return client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            response.body?.string()?.let { json ->
                return gson.fromJson(json, MovieApiClient.Movie::class.java)
            }
            return null
        }
    }
}
