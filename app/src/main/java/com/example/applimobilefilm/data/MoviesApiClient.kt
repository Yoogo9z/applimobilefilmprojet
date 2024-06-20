//package com.example.applimobilefilm.data
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object MoviesApiClient {
//
//    private const val BASE_URL = "https://api.example.com/"
//
//    fun create(): MoviesApi {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        return retrofit.create(MoviesApi::class.java)
//    }
//}
