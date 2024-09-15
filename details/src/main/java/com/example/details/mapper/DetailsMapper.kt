package com.example.details.mapper

import com.example.details.entity.CatImage
import javax.inject.Inject

class DetailsMapper @Inject constructor() {

    fun extractUrl(list: List<CatImage>): List<String>{
        var retutnable: MutableList<String> = mutableListOf()

        for(entity: CatImage in list){
            retutnable.add(entity.url)
        }

        return retutnable
    }

}