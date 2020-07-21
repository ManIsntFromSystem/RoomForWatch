package com.quantumman.data.remote.helpers

import android.content.Context
import android.content.SharedPreferences
import com.quantumman.data.remote.model.Genres


object SharedPrefsHelper {

    private val SHARED_PREF_FILE_NAME =
        SharedPrefsHelper::class.java.getPackage().toString()
    private const val KEY = "all_genres"
    private fun getAppPrefs(pContext: Context): SharedPreferences {
        return pContext.getSharedPreferences(
            SHARED_PREF_FILE_NAME,
            Context.MODE_PRIVATE
        )
    }

    private fun getEditor(appPreferences: SharedPreferences): SharedPreferences.Editor {
        return appPreferences.edit()
    }

//    fun saveListOfGenres(
//        context: Context,
//        genres: List<Genres.Genre>
//    ) {
//        val editor =
//            getEditor(getAppPrefs(context))
//        val gson = Gson()
//        val json: String = gson.toJson(genres)
//        editor.putString(KEY, json)
//        editor.apply()
//    }
//
//    fun getListOfGenres(context: Context?): List<Genres.Genre> {
//        val genres: List<Genres.Genre>
//        val gson = Gson()
//        val json =
//            getAppPrefs(context).getString(KEY, null)!!
//        if (json.isEmpty()) {
//            genres = ArrayList()
//        } else {
//            val type: Type =
//                object : TypeToken<List<Genres.Genre?>?>() {}.getType()
//            genres = gson.fromJson(json, type)
//        }
//        return genres
//    }
}