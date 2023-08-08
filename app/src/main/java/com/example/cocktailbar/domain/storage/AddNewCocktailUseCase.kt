package com.example.cocktailbar.domain.storage

import com.example.cocktailbar.domain.models.Cocktail
import com.example.cocktailbar.domain.repositories.StorageRepository

class AddNewCocktailUseCase(private val storageRepository: StorageRepository) {

    suspend fun execute(cocktail: Cocktail) = storageRepository.addNewCocktail(cocktail)
}