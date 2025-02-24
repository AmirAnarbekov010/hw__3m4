package com.example.rickandmorty.data.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.db.daos.FavoriteCharacterDao
import com.example.rickandmorty.model.CharacterModel

@Database(entities = [CharacterModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteCharacterDao(): FavoriteCharacterDao
}