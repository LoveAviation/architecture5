package com.example.list

import com.example.list.data.CatFactRepository
import com.example.list.entity.CatFact
import javax.inject.Inject

class ListRepository @Inject constructor(
    private val catFactRepository: CatFactRepository
) {

    suspend fun getFacts(count: Int): List<String>{
        return catFactRepository.getCatFact(count).data
    }

}