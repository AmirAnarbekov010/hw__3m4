package com.example.hw__3m4.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw__3m4.data.daos.NoteDao
import com.example.hw__3m4.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}