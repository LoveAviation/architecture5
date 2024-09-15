package com.example.favorites

import androidx.lifecycle.LiveData
import com.example.favorites.domain.FavoriteFactRepository
import com.example.favorites.entity.FavoriteFactEntity
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    private val favoriteFactRepository: FavoriteFactRepository
) {

    suspend fun getAllFavorites(): List<FavoriteFactEntity> {
        return favoriteFactRepository.getAllCatFacts()
    }

    suspend fun addFavorite(image: String, fact: String){
        favoriteFactRepository.insertCatFact(FavoriteFactEntity(
            image = image, fact = fact))
    }

    suspend fun deleteFavorite(image: String, fact: String) {
        favoriteFactRepository.deleteCatFact(image, fact)
    }
}