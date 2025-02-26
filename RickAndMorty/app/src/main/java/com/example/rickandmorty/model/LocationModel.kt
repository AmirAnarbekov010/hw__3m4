package com.example.rickandmorty.model

import com.example.rickandmorty.data.dto.LocationResponse

data class LocationModel(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
)

fun LocationResponse.toLocationModel(): LocationModel {
    return LocationModel(
        id = this.id,
        name = this.name,
        type = this.type,
        dimension = this.dimension
    )
}