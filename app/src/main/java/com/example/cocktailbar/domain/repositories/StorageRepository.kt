package com.example.cocktailbar.domain.repositories

import com.example.cocktailbar.domain.models.Cocktail

interface StorageRepository {

    suspend fun addNewCocktail(cocktail: Cocktail)
    suspend fun deleteCocktail(cocktail: Cocktail)
    suspend fun getAllCocktails(): List<Cocktail>
    suspend fun getCocktail(id: Int): Cocktail
    suspend fun editCocktail(cocktail: Cocktail)
}