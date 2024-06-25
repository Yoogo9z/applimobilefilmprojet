package com.example.applimobilefilm.repository

import com.example.applimobilefilm.api.MovieApiService
import com.example.applimobilefilm.domaine.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {

    private val service: MovieApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyapi.online/api/movies")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(MovieApiService::class.java)
    }

    suspend fun getPopularMovies(apiKey: String): List<Movie>? {
        return try {
            val response = service.getPopularMovies(apiKey)
            if (response.isSuccessful) {
                response.body()?.movies
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}
