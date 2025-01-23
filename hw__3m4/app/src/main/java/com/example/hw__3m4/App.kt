package com.example.hw__3m4

import android.app.Application
import androidx.room.Room
import com.example.hw__3m4.data.AppDatabase

class App : Application() {

    companion object {
        private var appDatabase: AppDatabase? = null

        fun getInstance(): AppDatabase? {
            return appDatabase
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "note.database"
            ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}