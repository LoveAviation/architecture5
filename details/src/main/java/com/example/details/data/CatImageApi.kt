package com.example.details.data

import retrofit2.http.GET
import retrofit2.http.Query

interface CatImageApi {
    @GET("search?")
    suspend fun getCatImage(@Query("limit") count: Int): List<CatImageDto>
}