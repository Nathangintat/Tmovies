package com.example.tmovies.presentation.movie_detail

import com.example.tmovies.domain.model.Movie
import com.example.tmovies.domain.model.MovieDetail

data class MovieDetailState(

    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = ""
)
