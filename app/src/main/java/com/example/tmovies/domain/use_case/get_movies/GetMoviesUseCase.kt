package com.example.tmovies.domain.use_case.get_movies

import androidx.paging.PagingData
import com.example.tmovies.domain.model.Movie
import com.example.tmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
){
    operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.getMovies()
    }
}