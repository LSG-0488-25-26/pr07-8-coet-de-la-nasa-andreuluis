package com.example.rickymorty.data.repository

import com.example.rickymorty.data.remote.RickAndMortyApi
import com.example.rickymorty.ui.model.Character

class CharactersRepository(private val api: RickAndMortyApi) {

    suspend fun getCharacters(page: Int = 1): List<Character> {
        val response = api.getCharacters(page)
        return response.results.map { it.toDomain() }
    }

    suspend fun getCharacterById(id: Int): Character {
        return api.getCharacterById(id).toDomain()
    }
}

private fun com.example.rickymorty.data.remote.ApiCharacter.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        origin = origin.name,
        imageUrl = image
    )
}
