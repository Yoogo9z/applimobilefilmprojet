package com.example.applimobilefilm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applimobilefilm.domaine.model.Movie
import com.example.applimobilefilm.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    fun fetchMovies(apiKey: String) {
        viewModelScope.launch {
            val moviesList = repository.getPopularMovies(apiKey)
            _movies.value = moviesList ?: emptyList()
        }
    }
}
