package com.example.tmovies.domain.use_case.user

import com.example.tmovies.domain.model.UserProfile
import com.example.tmovies.domain.repository.MovieRepository
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(userProfile: UserProfile) {
        repository.saveProfile(userProfile)
    }
}