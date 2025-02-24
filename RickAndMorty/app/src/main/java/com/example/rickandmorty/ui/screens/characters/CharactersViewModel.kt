package com.example.rickandmorty.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.data.repository.CharactersRepository

class CharactersViewModel(private val charactersRepository: CharactersRepository) : ViewModel() {
    val characters = charactersRepository.getCharactersPager()
        .flow
        .cachedIn(viewModelScope)
}