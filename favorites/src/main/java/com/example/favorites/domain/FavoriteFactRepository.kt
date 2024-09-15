package com.example.favorites.domain

import androidx.lifecycle.LiveData
import com.example.favorites.entity.FavoriteFactEntity
import javax.inject.Inject

class FavoriteFactRepository @Inject constructor(
    database: CatFactDatabase
) {

    private val dao = database.imageFactDao()

    suspend fun getAllCatFacts() : List<FavoriteFactEntity> = dao.getAll()

    suspend fun insertCatFact(imageFact: FavoriteFactEntity) {
        dao.insert(imageFact)
    }

    suspend fun deleteCatFact(image: String, fact: String) {
        dao.deleteCatFact(image, fact)
    }
}