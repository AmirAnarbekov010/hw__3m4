package com.example.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmorty.data.api.CharacterApiService
import com.example.rickandmorty.data.paging.character.CharactersPagingSource
import com.example.rickandmorty.model.CharacterModel
import com.example.rickandmorty.model.toCharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharactersRepository(private val apiService: CharacterApiService) {

    fun getCharactersPager(): Pager<Int, CharacterModel> {
        return Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 10,
                initialLoadSize = 60, enablePlaceholders = false),
            pagingSourceFactory = { CharactersPagingSource(apiService) }
        )
    }

    fun getCharacterById(characterId: Int): Flow<CharacterModel?> {
        return flow {
            try {
                var page = 1
                var characterModel: CharacterModel? = null

                while (characterModel == null) {
                    val charactersResponse = apiService.getAllCharacters(page)
                    characterModel = charactersResponse.charactersResponse.find { it.id == characterId }?.toCharacterModel()

                    if (characterModel != null) {
                        emit(characterModel)
                        break
                    }
                    page++
                }

                if (characterModel == null) {
                    emit(null)
                }
            } catch (e: Exception) {
                emit(null)
            }
        }
    }
}