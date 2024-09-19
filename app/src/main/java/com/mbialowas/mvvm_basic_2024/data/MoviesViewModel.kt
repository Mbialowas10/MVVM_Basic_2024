package com.mbialowas.mvvm_basic_2024.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MoviesViewModel() : ViewModel() {

    private val _movies = mutableStateListOf<Movie>().apply {addAll(moviesList)}
    val movies: List<Movie> = _movies

    fun toggleFavorite(movieID: Int, isFavorite: Boolean) {
        val movieIndex = _movies.indexOfFirst { it.id == movieID }
        if (movieIndex != -1) {
            _movies[movieIndex] = _movies[movieIndex].copy(isFavorite = isFavorite)
        }

    }

}