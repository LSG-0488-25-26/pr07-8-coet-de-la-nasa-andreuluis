package com.example.rickymorty.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickymorty.data.repository.CharactersRepository
import com.example.rickymorty.ui.model.Character
import kotlinx.coroutines.launch

class CharacterVM(private val repo: CharactersRepository) : ViewModel() {

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
}
