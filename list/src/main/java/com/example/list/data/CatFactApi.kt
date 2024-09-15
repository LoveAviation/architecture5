package com.example.list.data

import retrofit2.http.GET
import retrofit2.http.Query

interface CatFactApi {
    @GET("?")
    suspend fun getCatFact(@Query("count") count: Int): CatFactDto
}