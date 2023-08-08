package com.example.cocktailbar.domain.storage

import com.example.cocktailbar.domain.models.Cocktail
import com.example.cocktailbar.domain.repositories.StorageRepository

class EditCocktailUseCase(private val storageRepository: StorageRepository)  {

    suspend fun execute(cocktail: Cocktail) = storageRepository.editCocktail(cocktail)
}