package com.example.rickandmorty.data.paging.episode

import com.example.rickandmorty.model.EpisodeModel

sealed class EpisodeDetailState {
    object Loading : EpisodeDetailState()
    data class Success(val episode: EpisodeModel) : EpisodeDetailState()
    data class Error(val message: String) : EpisodeDetailState()
}