package com.example.hw__3m4.Utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.pm.ShortcutInfoCompatSaver.NoopImpl

class SharedPreferenceHelper(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "shared",
        Context.MODE_PRIVATE
    )

    fun setOnBoardingComplete(isComplete: Boolean) {
        sharedPreferences.edit().putBoolean(SHOWED, isComplete).apply()
    }

    fun isOnBoardingComplete(): Boolean {
        return sharedPreferences.getBoolean(SHOWED, false)
    }

    companion object{
        const val SHOWED = "showed"
    }
}