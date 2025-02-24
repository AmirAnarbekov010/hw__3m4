package com.example.rickandmorty.ui.screens.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.data.repository.EpisodesRepository

class EpisodesViewModel(private val episodesRepository: EpisodesRepository) : ViewModel() {
    val episodes = episodesRepository.getEpisodesPager()
        .flow
        .cachedIn(viewModelScope)
}