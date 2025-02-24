package com.example.rickandmorty.data.db.daos
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.model.CharacterModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteCharacter(character: CharacterModel)

    @Delete
    suspend fun removeFavoriteCharacter(character: CharacterModel)

    @Query("SELECT * FROM favorite_characters")
    fun getAllFavoriteCharacters(): Flow<List<CharacterModel>>

    @Query("SELECT * FROM favorite_characters WHERE id = :id LIMIT 1")
    suspend fun getFavoriteCharacterById(id: Int): CharacterModel?
}