package com.example.rickymorty.ui.ViewModel

import com.example.rickymorty.R
import com.example.rickymorty.ui.model.Character

fun getCharacterList(): MutableList<Character> {
    val characters: MutableList<Character> = mutableListOf()

    characters.add(Character(1, "Rick Sanchez", "Alive", "Human", "Male", "Earth (C-137)", R.drawable.rick))
    characters.add(Character(2, "Morty Smith", "Alive", "Human", "Male", "Earth (C-137)", R.drawable.morty))
    characters.add(Character(3, "Summer Smith", "Alive", "Human", "Female", "Earth (Replacement Dimension)", R.drawable.summer))
    characters.add(Character(4, "Beth Smith", "Alive", "Human", "Female", "Earth (Replacement Dimension)", R.drawable.beth))
    characters.add(Character(5, "Jerry Smith", "Alive", "Human", "Male", "Earth (Replacement Dimension)", R.drawable.jerry))
    characters.add(Character(7, "Abradolf Lincler", "unknown", "Human", "Male", "Earth (Replacement Dimension)", R.drawable.abradolf))
    characters.add(Character(47, "Birdperson", "Dead", "Alien", "Male", "Bird World", R.drawable.birdperson))
    characters.add(Character(85, "President Curtis", "Alive", "Human", "Male", "Earth (Replacement Dimension)", R.drawable.president))

    return characters
}
