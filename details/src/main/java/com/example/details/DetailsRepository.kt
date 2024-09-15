package com.example.details

import com.example.details.data.CatImageRepository
import com.example.details.mapper.DetailsMapper
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val catImageRepository: CatImageRepository,
    private val mapper: DetailsMapper
) {

    suspend fun getImagesUrl(count: Int): List<String>{
        return mapper.extractUrl(catImageRepository.getCatImage(count))
    }

}