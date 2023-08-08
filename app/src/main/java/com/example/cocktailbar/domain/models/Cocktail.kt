package com.example.cocktailbar.domain.models

data class Cocktail(
    val id: Int = 0,
    val imageSrc: Int,
    val name: String,
    val description: String,
    val recipe: String,
    val ingredients: List<String>
)