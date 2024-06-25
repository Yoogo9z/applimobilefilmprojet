package com.example.applimobilefilm.api

import com.example.applimobilefilm.domaine.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movies")
    suspend fun getPopularMovies(@Query("apiKey") apiKey: String): Response<MoviesResponse>
}
