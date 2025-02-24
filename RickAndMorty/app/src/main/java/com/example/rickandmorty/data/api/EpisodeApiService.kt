package com.example.rickandmorty.data.api
import com.example.rickandmorty.data.dto.EpisodesResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun getAllEpisodes(
        @Query("page") page: Int
    ): EpisodesResultResponse
}