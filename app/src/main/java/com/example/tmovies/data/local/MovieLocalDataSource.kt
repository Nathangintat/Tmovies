package com.example.tmovies.data.local

import com.example.tmovies.data.local.preferences.AppDataStore
import com.example.tmovies.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieLocalDataSource @Inject constructor(
    private val dataStore: AppDataStore
) {

    suspend fun saveUser(
        userProfile: UserProfile
    ) {
        dataStore.saveUser(userProfile)
    }

    fun getUser(): Flow<UserProfile> {
        return dataStore.readUser
    }
}