package com.example.rickandmorty.data.dto

import com.example.rickandmorty.data.paging.PagingInfo
import com.google.gson.annotations.SerializedName

data class EpisodesResultResponse(
    @SerializedName("info")
    val pagingInfo: PagingInfo,
    @SerializedName("results")
    val episodesResponse: List<EpisodeResponse>
)

data class EpisodeResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: String
)