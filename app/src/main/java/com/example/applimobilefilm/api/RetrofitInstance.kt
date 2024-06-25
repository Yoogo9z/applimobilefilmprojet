package com.example.applimobilefilm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: Any
        get() {
            TODO()
        }
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val API_KEY = "votre_clé_api_ici" // Remplacez par votre clé API TMDb

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val movieApiService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}
