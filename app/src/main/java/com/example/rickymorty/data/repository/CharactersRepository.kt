package com.example.rickymorty.data.repository

import com.example.rickymorty.data.local.FavoriteCharacterDao
import com.example.rickymorty.data.local.FavoriteCharacterEntity
import com.example.rickymorty.data.remote.RickAndMortyApi
import com.example.rickymorty.ui.model.Character

class CharactersRepository(
    private val api: RickAndMortyApi,
    private val dao: FavoriteCharacterDao
) {
    suspend fun getCharacters(page: Int): List<Character> {
        val response = api.getCharacters(page)
        return response.results.map {
            Character(
                id = it.id,
                name = it.name,
                status = it.status,
                species = it.species,
                gender = it.gender,
                origin = it.origin.name,
                imageUrl = it.image
            )
        }
    }

    suspend fun getCharacterById(id: Int): Character {
        val it = api.getCharacterById(id)
        return Character(
            id = it.id,
            name = it.name,
            status = it.status,
            species = it.species,
            gender = it.gender,
            origin = it.origin.name,
            imageUrl = it.image
        )
    }

    // base d dades
    fun getFavorites(): List<FavoriteCharacterEntity> = dao.getAll()
    fun isFavorite(id: Int): Boolean = dao.isFavorite(id)
    fun addFavorite(entity: FavoriteCharacterEntity) = dao.insert(entity)
    fun removeFavorite(entity: FavoriteCharacterEntity) = dao.delete(entity)
}
