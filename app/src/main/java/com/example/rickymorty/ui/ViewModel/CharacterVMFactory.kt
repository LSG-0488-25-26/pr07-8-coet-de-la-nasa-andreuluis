 package com.example.rickymorty.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickymorty.data.repository.CharactersRepository

class CharacterVMFactory(
    private val repo: CharactersRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterVM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharacterVM(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
