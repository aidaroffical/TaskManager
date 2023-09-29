package com.example.taskmanager.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(private val context: Context) {

    private val pref = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE)

    fun isUserShow(): Boolean {
        return pref.getBoolean(BOARD_KEY, false)
    }

    fun userShowed(){
        pref.edit().putBoolean(BOARD_KEY, true).apply()
    }

    fun saveName(name: String) {
        pref.edit().putString(NAME_KEY, name).apply()
    }

    fun saveImage(name: String) {
        pref.edit().putString(IMAGE_KEY, name).apply()
    }

    fun getName() = pref.getString(NAME_KEY, "")
    fun getImage() = pref.getString(IMAGE_KEY, "")


    companion object {
        const val IMAGE_KEY = "image.key"
        const val PREF_KEY = "pref.key"
        const val BOARD_KEY = "board.key"
        const val NAME_KEY = "name.key"
    }
}