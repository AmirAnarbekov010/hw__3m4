

import com.example.rickandmorty.data.db.daos.FavoriteCharacterDao
import com.example.rickandmorty.model.CharacterModel

class FavoriteCharactersRepository(private val dao: FavoriteCharacterDao) {
    val favoriteCharacters = dao.getAllFavoriteCharacters()

    suspend fun addFavoriteCharacter(character: CharacterModel) {
        dao.addFavoriteCharacter(character)
    }

    suspend fun removeFavoriteCharacter(character: CharacterModel) {
        dao.removeFavoriteCharacter(character)
    }

    suspend fun isFavorite(id: Int): Boolean {
        return dao.getFavoriteCharacterById(id) != null
    }
}