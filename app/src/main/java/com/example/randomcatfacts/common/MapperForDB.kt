package com.example.randomcatfacts.common

import com.example.favorites.entity.FavoriteFactEntity

class MapperForDB {

    fun extractImageList(input: List<FavoriteFactEntity>): List<String>{
        var returnable = mutableListOf<String>()

        for (item: FavoriteFactEntity in input){
            returnable.add(item.image)
        }

        return returnable
    }

    fun extractFactList(input: List<FavoriteFactEntity>): List<String>{
        var returnable = mutableListOf<String>()

        for (item: FavoriteFactEntity in input){
            returnable.add(item.fact)
        }

        return returnable
    }

}