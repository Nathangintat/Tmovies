package com.example.tmovies.data.local.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.tmovies.domain.model.UserProfile
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val Context.dataStore by preferencesDataStore(name = "app_data_store")

    suspend fun saveUser(userProfile: UserProfile) {
        context.dataStore.edit { preferences ->
            preferences[NAME] = userProfile.name
            preferences[PROFILE_PICTURE] = userProfile.profilePicture
            preferences[GMAIL] = userProfile.gmail
            preferences[USERNAME] = userProfile.username
            preferences[TELEPHONE] = userProfile.telephone
        }
    }

    val readUser: Flow<UserProfile>
        get() = context.dataStore.data.map {preferences ->
            UserProfile(
                name =  preferences[NAME] ?: "",
                profilePicture = preferences[PROFILE_PICTURE] ?: "",
                gmail = preferences[GMAIL] ?: "",
                username = preferences[USERNAME] ?: "",
                telephone = preferences[TELEPHONE] ?: ""
            )
        }

    companion object {
        private val NAME = stringPreferencesKey("name")
        private val PROFILE_PICTURE = stringPreferencesKey("profile_picture")
        private val GMAIL = stringPreferencesKey("gmail")
        private val USERNAME = stringPreferencesKey("username")
        private val TELEPHONE = stringPreferencesKey("telephone")

    }
}