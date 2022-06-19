package com.tashuseyin.case_3gram.data.data_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.tashuseyin.case_3gram.common.Constant
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


class DataStoreRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val Context.dataStore by preferencesDataStore(Constant.PREFERENCES_NAME)

    private object PreferenceKeys {
        val isToolbarTitleState = booleanPreferencesKey(Constant.TOOLBAR_TITLE_STATE)
    }

    private val dataStore: DataStore<Preferences> = context.dataStore

    val readToolbarTitleState: Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map {
            val token = it[PreferenceKeys.isToolbarTitleState] ?: false
            token
        }

    suspend fun saveToolbarTitleState(isSearched: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.isToolbarTitleState] = isSearched
        }
    }

}
