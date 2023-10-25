package com.example.tmovies.domain.model

import com.example.tmovies.data.remote.dto.MovieDetailDto

data class MovieDetail(
    val genres: List<MovieDetailDto.Genre>,
    val title: String,
    val posterPath: String,
    val id: Int,
    val voteAverage: Double,
    val voteCount: Int,
    val adult: Boolean,
    val runtime: Int,
    val releaseDate: String,
    val overview: String
)
