package com.example.favorites.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.favorites.entity.FavoriteFactEntity

@Database(entities = [FavoriteFactEntity::class], version = 1)
abstract class CatFactDatabase : RoomDatabase() {
    abstract fun imageFactDao(): CatFactDAO
}