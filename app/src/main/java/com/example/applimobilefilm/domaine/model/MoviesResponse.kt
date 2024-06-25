package com.example.applimobilefilm.domaine.model

data class MoviesResponse(
    val movies: List<Movie>,
    val total: Int
)

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Float
)
