package com.example.testwork

data class Food(
    val food: List<FoodList>
)
data class FoodList(
val id: Int,
val category_id: Int,
val name: String,
val description: String,
val image: String,
val price_current: Int,
val energy_per_100_grams: Double,
val proteins_per_100_grams: Double,
val fats_per_100_grams: Double,
val carbohydrates_per_100_grams: Double
)