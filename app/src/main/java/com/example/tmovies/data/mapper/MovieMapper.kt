package com.example.tmovies.data.mapper

import com.example.tmovies.data.remote.dto.MovieDetailDto
import com.example.tmovies.data.remote.dto.MovieDto
import com.example.tmovies.domain.model.Movie
import com.example.tmovies.domain.model.MovieDetail

object MovieMapper {
    fun MovieDto.toMovie(): Movie {
        return Movie(
            id = id,
            voteAverage = vote_average,
            popularity = popularity,
            adult = adult,
            posterPath = poster_path,
            title = title,
            voteCount = vote_count
        )
    }

    fun MovieDetailDto.toMovieDetail(): MovieDetail {
        return MovieDetail(
            id = id,
            adult = adult,
            genres = genres,
            posterPath = poster_path,
            releaseDate = release_date,
            runtime = runtime,
            title = title,
            voteCount = vote_count,
            voteAverage = vote_average,
            overview = overview
        )
    }
}