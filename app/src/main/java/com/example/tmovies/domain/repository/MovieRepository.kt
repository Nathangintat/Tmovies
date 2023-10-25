package com.example.tmovies.domain.repository

import androidx.paging.PagingData
import com.example.tmovies.data.local.MovieLocalDataSource
import com.example.tmovies.domain.model.Movie
import com.example.tmovies.domain.model.MovieDetail
import com.example.tmovies.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

     fun getMovies(): Flow<PagingData<Movie>>

    suspend fun getMovieById(movieId: String): MovieDetail

    fun getProfile(): Flow<UserProfile>

    suspend fun saveProfile(userProfile: UserProfile)
}