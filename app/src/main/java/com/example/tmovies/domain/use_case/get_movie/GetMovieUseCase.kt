package com.example.tmovies.domain.use_case.get_movie

import com.example.tmovies.domain.util.Resource
import com.example.tmovies.domain.model.MovieDetail
import com.example.tmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository,
){
    operator fun invoke(movieId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getMovieById(movieId)
            emit(Resource.Success(movie))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error occurred"))

        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server"))
        }
    }
}