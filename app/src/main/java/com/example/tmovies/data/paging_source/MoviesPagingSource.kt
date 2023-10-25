package com.example.tmovies.data.paging_source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tmovies.data.mapper.MovieMapper.toMovie
import com.example.tmovies.data.remote.MovieApi
import com.example.tmovies.domain.model.Movie
import retrofit2.HttpException
import java.io.IOException

class MoviesPagingSource(
    private val remoteDataSource: MovieApi,
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val movies = remoteDataSource.getMovies(
                page = currentPage
            )

            Log.d("MOVIES DATA", movies.status_message ?: "")
            Log.d("MOVIES DATA", movies.results.toString())

            if (movies.results == null) {
                throw Error("data null")
            }

            LoadResult.Page(
                data = movies.results.map { it.toMovie() },
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (movies.results.isEmpty()) null else (movies.page ?: 0) + 1
            )
        } catch (exception: IOException) {
            Log.e("ERROR", exception.message ?: "")
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            Log.e("ERROR", exception.message ?: "")
            return LoadResult.Error(exception)
        } catch (exception: Exception) {
            Log.e("ERROR", exception.message ?: "")
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}