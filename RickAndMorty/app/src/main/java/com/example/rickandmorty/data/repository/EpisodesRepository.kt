package com.example.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmorty.data.api.EpisodeApiService
import com.example.rickandmorty.data.paging.episode.EpisodePagingSource
import com.example.rickandmorty.model.EpisodeModel
import com.example.rickandmorty.model.toEpisodeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EpisodesRepository(private val apiService: EpisodeApiService) {

    fun getEpisodesPager(): Pager<Int, EpisodeModel> {
        return Pager(
            config = PagingConfig(
                pageSize = 20, prefetchDistance = 10,
                initialLoadSize = 60, enablePlaceholders = false
            ),
            pagingSourceFactory = { EpisodePagingSource(apiService) }
        )
    }

    fun getEpisodeById(episodeId: Int): Flow<EpisodeModel?> {
        return flow {
            try {
                var page = 1
                var episodeModel: EpisodeModel? = null

                while (episodeModel == null) {
                    val episodesResponse = apiService.getAllEpisodes(page)
                    episodeModel = episodesResponse.episodesResponse.find { it.id == episodeId }?.toEpisodeModel()

                    if (episodeModel != null) {
                        emit(episodeModel)
                        break
                    }
                    page++
                }

                if (episodeModel == null) {
                    emit(null)
                }
            } catch (e: Exception) {
                emit(null)
            }
        }
    }
}