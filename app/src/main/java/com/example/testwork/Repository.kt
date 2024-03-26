package com.example.testwork

class Repository {
    suspend fun getActivityInfo(): List<FoodList>{
        return try{
            FoodApi.foodRandom.getPhoto().food
        } catch ( t:Throwable) {
            println("Ошибка $t")
            emptyList()
        }
    }
}