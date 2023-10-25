package com.example.tmovies.presentation.movie_list

import com.example.tmovies.domain.model.Movie

data class MovieListState(

    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
