package com.example.cocktailbar.data.db.impl

import com.example.cocktailbar.data.db.CocktailsDatabase
import com.example.cocktailbar.data.db.RoomStorage
import com.example.cocktailbar.data.db.dto.CocktailDto

class RoomStorageImpl(cocktailsDatabase: CocktailsDatabase): RoomStorage {

    private val cocktailsDao = cocktailsDatabase.cocktailDao()

    override suspend fun addNewCocktail(cocktailDto: CocktailDto) {
        cocktailsDao.addNewItem(cocktailDto)
    }

    override suspend fun deleteCocktail(cocktailDto: CocktailDto) {
        cocktailsDao.deleteItem(cocktailDto)
    }

    override suspend fun getAllCocktails(): List<CocktailDto>  = cocktailsDao.getAllCocktails()

    override suspend fun getCocktail(id: Int): CocktailDto = cocktailsDao.getCocktail(id)

    override suspend fun editCocktail(cocktailDto: CocktailDto) {
        cocktailsDao.editItem(cocktailDto)
    }
}