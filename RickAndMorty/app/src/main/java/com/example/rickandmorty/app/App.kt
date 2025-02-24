package com.example.rickandmorty.app
import android.app.Application
import androidx.room.Room
import com.example.rickandmorty.data.db.AppDatabase
import com.example.rickandmorty.data.serviceLocator.dataModule
import com.example.rickandmorty.data.serviceLocator.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    private lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "app_database"
        ).build()

        startKoin {
            androidContext(this@App)
            modules(dataModule, uiModule)
        }
    }
}