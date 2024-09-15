package com.example.favorites.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_facts")
data class FavoriteFactEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val image: String,
    val fact: String
)