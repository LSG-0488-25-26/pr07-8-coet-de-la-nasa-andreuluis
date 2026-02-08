package com.example.rickymorty.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteCharacterDao {

    @Query("SELECT * FROM favorite_characters")
    fun getAll(): List<FavoriteCharacterEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_characters WHERE id = :id)")
    fun isFavorite(id: Int): Boolean

    @Insert
    fun insert(entity: FavoriteCharacterEntity)

    @Delete
    fun delete(entity: FavoriteCharacterEntity)
}
