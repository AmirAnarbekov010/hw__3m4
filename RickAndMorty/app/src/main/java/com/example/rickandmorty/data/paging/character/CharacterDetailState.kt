package com.example.rickandmorty.data.paging.character
import com.example.rickandmorty.model.CharacterModel

sealed class CharacterDetailState {
    object Loading : CharacterDetailState()
    data class Success(val character: CharacterModel) : CharacterDetailState()
    data class Error(val message: String) : CharacterDetailState()
}