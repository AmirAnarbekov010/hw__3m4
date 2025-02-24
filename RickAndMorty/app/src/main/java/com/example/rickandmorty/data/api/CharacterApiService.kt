package com.example.rickandmorty.data.api
import com.example.rickandmorty.data.dto.CharactersResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): CharactersResultResponse
}