package com.example.tmovies.domain.model

data class Movie(
    val title: String,
    val popularity: Double,
    val posterPath: String,
    val id: Int,
    val voteAverage: Double,
    val voteCount: Int,
    val adult: Boolean,
)
