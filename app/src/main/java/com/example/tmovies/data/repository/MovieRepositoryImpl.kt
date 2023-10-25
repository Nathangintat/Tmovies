package com.example.tmovies.data.repository


import androidx.datastore.dataStore
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tmovies.data.local.MovieLocalDataSource
import com.example.tmovies.data.local.preferences.AppDataStore
import com.example.tmovies.data.mapper.MovieMapper.toMovieDetail
import com.example.tmovies.data.paging_source.MoviesPagingSource
import com.example.tmovies.data.remote.MovieApi
import com.example.tmovies.domain.model.Movie
import com.example.tmovies.domain.model.MovieDetail
import com.example.tmovies.domain.model.UserProfile
import com.example.tmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {

    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 15),
            pagingSourceFactory = {
                MoviesPagingSource(api)
            }
        ).flow
    }

    override suspend fun getMovieById(movieId: String): MovieDetail {
        return api.getMovieById(movieId).toMovieDetail()
    }

    override fun getProfile(): Flow<UserProfile> {
        return movieLocalDataSource.getUser()
    }

    override suspend fun saveProfile(userProfile: UserProfile) {
        movieLocalDataSource.saveUser(userProfile)
    }
}