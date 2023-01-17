package com.example.datastoreexample

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context: Context) {
    val Context.ds: DataStore<Preferences> by preferencesDataStore("informations")

    companion object {
        val NAME_KEY = stringPreferencesKey("NAME")
    }

    suspend fun saveName(name: String) {
        context.ds.edit {
            it[NAME_KEY] = name
        }
    }

    suspend fun readName(): String {
        val p = context.ds.data.first()
        return p[NAME_KEY] ?: "No name"
    }

    suspend fun deleteName() {
        context.ds.edit {
            it.remove(NAME_KEY)
        }
    }
}