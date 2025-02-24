package com.example.rickandmorty.ui.screens.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.data.repository.LocationsRepository

class LocationsViewModel(private val locationsRepository: LocationsRepository) : ViewModel() {
    val locations = locationsRepository.getLocationsPager()
        .flow
        .cachedIn(viewModelScope)
}