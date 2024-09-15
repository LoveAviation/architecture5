package com.example.list.data

import com.example.list.entity.CatFact
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CatFactRepository @Inject constructor(){
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://meowfacts.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(CatFactApi::class.java)


    suspend fun getCatFact(count: Int): CatFact {
        return api.getCatFact(count)
    }
}