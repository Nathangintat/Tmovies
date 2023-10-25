package com.example.tmovies.domain.use_case.user

import com.example.tmovies.domain.model.UserProfile
import com.example.tmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<UserProfile> {
        return repository.getProfile()
    }
}