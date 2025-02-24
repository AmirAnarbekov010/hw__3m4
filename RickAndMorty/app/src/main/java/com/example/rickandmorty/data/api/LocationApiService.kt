package com.example.rickandmorty.data.api
import com.example.rickandmorty.data.dto.LocationsResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun getAllLocations(
        @Query("page") page: Int
    ): LocationsResultResponse
}