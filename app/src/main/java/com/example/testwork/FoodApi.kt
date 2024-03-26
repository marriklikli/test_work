package com.example.testwork

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


private const val BASE_URL = "https://drive.google.com/"
private const val API_KEY = "/file/d/1mU9wmvfaqiArQr_ZX0aedyuEnbj4LfMY/view?usp=share_link"

object FoodApi {private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    val foodRandom : FoodRandom = retrofit.create(FoodRandom::class.java)
}

interface FoodRandom {

    suspend fun getPhoto (
        @Query("api_key") api_key:String = API_KEY
    ): Food
}
