package com.example.rickandmorty.data.paging.location

import com.example.rickandmorty.model.LocationModel

sealed class LocationDetailState {
    object Loading : LocationDetailState()
    data class Success(val location: LocationModel) : LocationDetailState()
    data class Error(val message: String) : LocationDetailState()
}