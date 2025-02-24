package com.example.rickandmorty.data.paging.character

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.data.api.CharacterApiService
import com.example.rickandmorty.model.CharacterModel
import com.example.rickandmorty.model.toCharacterModel

class CharactersPagingSource(
    private val apiService: CharacterApiService
) : PagingSource<Int, CharacterModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getAllCharacters(currentPage)
            LoadResult.Page(
                data = response.charactersResponse.map { it.toCharacterModel() },
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (response.pagingInfo.nextPage.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }
}