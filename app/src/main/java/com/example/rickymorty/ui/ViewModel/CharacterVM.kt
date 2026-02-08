package com.example.rickymorty.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickymorty.data.local.FavoriteCharacterEntity
import com.example.rickymorty.data.repository.CharactersRepository
import com.example.rickymorty.ui.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterVM(
    private val repo: CharactersRepository
) : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>(emptyList())
    val characters: LiveData<List<Character>> = _characters

    private val _selected = MutableLiveData<Character?>(null)
    val selected: LiveData<Character?> = _selected

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    fun loadCharacters(page: Int = 1) {
        _loading.value = true
        _error.value = null
        viewModelScope.launch {
            try {
                _characters.value = repo.getCharacters(page)
            } catch (e: Exception) {
                _error.value = e.message ?: "Error carregant personatges"
            } finally {
                _loading.value = false
            }
        }
    }

    fun loadCharacterById(id: Int) {
        _loading.value = true
        _error.value = null
        viewModelScope.launch {
            try {
                _selected.value = repo.getCharacterById(id)
            } catch (e: Exception) {
                _error.value = e.message ?: "Error carregant detall"
            } finally {
                _loading.value = false
            }
        }
    }

    // SearchBar
    private val _searchedText = MutableLiveData("")
    val searchedText: LiveData<String> = _searchedText

    fun onSearchTextChange(text: String) {
        _searchedText.value = text
    }

    // Favorites Room
    private val _favorites = MutableLiveData<List<FavoriteCharacterEntity>>(emptyList())
    val favorites: LiveData<List<FavoriteCharacterEntity>> = _favorites

    private val _isFavorite = MutableLiveData(false)
    val isFavorite: LiveData<Boolean> = _isFavorite

    fun loadFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repo.getFavorites()
            withContext(Dispatchers.Main) { _favorites.value = list }
        }
    }

    fun checkIsFavorite(characterId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repo.isFavorite(characterId)
            withContext(Dispatchers.Main) { _isFavorite.value = res }
        }
    }

    fun toggleFavorite(character: Character) {
        viewModelScope.launch(Dispatchers.IO) {
            val entity = FavoriteCharacterEntity(
                id = character.id,
                name = character.name,
                status = character.status,
                species = character.species,
                gender = character.gender,
                origin = character.origin,
                imageUrl = character.imageUrl
            )

            if (repo.isFavorite(character.id)) repo.removeFavorite(entity)
            else repo.addFavorite(entity)

            val updated = repo.getFavorites()
            val nowFav = repo.isFavorite(character.id)

            withContext(Dispatchers.Main) {
                _favorites.value = updated
                _isFavorite.value = nowFav
            }
        }
    }
}
