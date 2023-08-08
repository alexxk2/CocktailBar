package com.example.cocktailbar.data.db

import com.example.cocktailbar.data.db.dto.CocktailDto

interface RoomStorage {

    suspend fun addNewCocktail(cocktailDto: CocktailDto)
    suspend fun deleteCocktail(cocktailDto: CocktailDto)
    suspend fun getAllCocktails(): List<CocktailDto>
    suspend fun getCocktail(id: Int): CocktailDto
    suspend fun editCocktail(cocktailDto: CocktailDto)
}