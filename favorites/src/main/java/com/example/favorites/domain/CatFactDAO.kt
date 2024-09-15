package com.example.favorites.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.favorites.entity.FavoriteFactEntity

@Dao
interface CatFactDAO {
    @Query("SELECT * FROM favorite_facts")
    suspend fun getAll(): List<FavoriteFactEntity>

    @Insert
    suspend fun insert(imageFact: FavoriteFactEntity)

    @Query("DELETE FROM favorite_facts WHERE image = :image AND fact = :fact")
    suspend fun deleteCatFact(image: String, fact: String)
}