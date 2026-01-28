package com.example.rickymorty.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

data class ApiCharactersResponse(
    val results: List<ApiCharacter>
)

data class ApiCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: ApiOrigin,
    val image: String
)

data class ApiOrigin(val name: String)

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int = 1): ApiCharactersResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): ApiCharacter
}
