package com.example.details.data

import com.example.details.entity.CatImage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CatImageRepository @Inject constructor(){

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/images/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(CatImageApi::class.java)


    suspend fun getCatImage(count: Int): List<CatImage> {
        return api.getCatImage(count)
    }

}