package com.example.tmovies.data.remote

import com.example.tmovies.data.remote.dto.MovieDetailDto
import com.example.tmovies.data.remote.dto.MoviesResultDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("/3/movie/popular")
    suspend fun getMovies(
        @Header("accept") accept: String = "application/json",
        @Header("Authorization") token: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDM4Nzg5NjQzODY0ODhhNzJkNzJlNmNhNTgyYTJiMyIsInN1YiI6IjY1MWQxNzA4ZjA0ZDAxMDExYzQ1MjgwMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.g7_TQ6AtAQirSNA81q6Z7N9BL3f6XhhdSqcWPhJ-SxM",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
    ): MoviesResultDto

    @GET("/3/movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: String,
        @Header("Authorization") token: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDM4Nzg5NjQzODY0ODhhNzJkNzJlNmNhNTgyYTJiMyIsInN1YiI6IjY1MWQxNzA4ZjA0ZDAxMDExYzQ1MjgwMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.g7_TQ6AtAQirSNA81q6Z7N9BL3f6XhhdSqcWPhJ-SxM",
        @Query("language") language: String = "en-US",
    ): MovieDetailDto

    companion object {
        const val BASE_URL = "https://api.themoviedb.org"

        const val PARAM_MOVIE_ID = "movieId"
    }
}