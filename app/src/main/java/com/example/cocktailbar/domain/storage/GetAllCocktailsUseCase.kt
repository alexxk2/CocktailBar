package com.example.cocktailbar.domain.storage

import com.example.cocktailbar.domain.models.Cocktail
import com.example.cocktailbar.domain.repositories.StorageRepository

class GetAllCocktailsUseCase(private val storageRepository: StorageRepository)  {

    suspend fun execute(): List<Cocktail> = storageRepository.getAllCocktails()
}