package com.example.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmorty.data.api.LocationApiService
import com.example.rickandmorty.data.paging.location.LocationPagingSource
import com.example.rickandmorty.model.LocationModel
import com.example.rickandmorty.model.toLocationModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocationsRepository(private val apiService: LocationApiService) {

    fun getLocationsPager(): Pager<Int, LocationModel> {
        return Pager(
            config = PagingConfig(
                pageSize = 20, prefetchDistance = 10,
                initialLoadSize = 60, enablePlaceholders = false
            ),
            pagingSourceFactory = { LocationPagingSource(apiService) }
        )
    }

    fun getLocationById(locationId: Int): Flow<LocationModel?> {
        return flow {
            try {
                var page = 1
                var locationModel: LocationModel? = null

                while (locationModel == null) {
                    val locationsResponse = apiService.getAllLocations(page)
                    locationModel = locationsResponse.locationsResponse.find { it.id == locationId }?.toLocationModel()

                    if (locationModel != null) {
                        emit(locationModel)
                        break
                    }
                    page++
                }

                if (locationModel == null) {
                    emit(null)
                }
            } catch (e: Exception) {
                emit(null)
            }
        }
    }
}