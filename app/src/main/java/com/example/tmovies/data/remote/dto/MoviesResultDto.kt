package com.example.tmovies.data.remote.dto

data class MoviesResultDto(
    val status_code: Int,
    val status_message: String?,
    val success: Boolean?,
    val page: Int?,
    val results: List<MovieDto>?
)