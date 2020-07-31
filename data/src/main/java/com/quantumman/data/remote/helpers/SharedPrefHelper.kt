package com.quantumman.data.remote.helpers

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.quantumman.data.remote.model.movies.Genres


object SharedPrefsHelper {

    private val SHARED_PREF_FILE_NAME = SharedPrefsHelper::class.java.getPackage().toString()
    private const val KEY = "all_genres"
    private fun getAppPrefs(pContext: Context): SharedPreferences {
        return pContext.getSharedPreferences(
            SHARED_PREF_FILE_NAME,
            Context.MODE_PRIVATE
        )
    }

    private fun getEditor(appPreferences: SharedPreferences): SharedPreferences.Editor = appPreferences.edit()

    fun saveListOfGenres(context: Context, genres: List<Genres>) = getEditor(getAppPrefs(context)).apply {
        putString(KEY, Gson().toJson(genres))
        apply()
    }

    fun getListOfGenres(context: Context): List<Genres> {

        val json = getAppPrefs(context).getString(KEY, null)
        return if (json != null && json.isEmpty()) listOf()
        else {
            val type = object : TypeToken<List<Genres>>() {}.type
            Gson().fromJson(json, type)
        }
    }
}