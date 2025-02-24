package com.example.rickandmorty.data.serviceLocator

import com.example.rickandmorty.ui.screens.characters.CharactersViewModel
import com.example.rickandmorty.ui.screens.characters.detail.CharacterDetailViewModel
import com.example.rickandmorty.ui.screens.episodes.EpisodesViewModel
import com.example.rickandmorty.ui.screens.episodes.detail.EpisodeDetailViewModel
import com.example.rickandmorty.ui.screens.fav.FavoriteCharactersViewModel
import com.example.rickandmorty.ui.screens.locations.LocationsViewModel
import com.example.rickandmorty.ui.screens.locations.detail.LocationDetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CharactersViewModel(get()) }
    viewModel { LocationsViewModel(get()) }
    viewModel { EpisodesViewModel(get()) }
    viewModel { FavoriteCharactersViewModel(get()) }
    viewModel { CharacterDetailViewModel(get()) }
    viewModel { EpisodeDetailViewModel(get()) }
    viewModel { LocationDetailViewModel(get()) }
}