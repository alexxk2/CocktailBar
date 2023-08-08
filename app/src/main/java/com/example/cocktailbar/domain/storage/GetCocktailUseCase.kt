package com.example.cocktailbar.domain.storage

import com.example.cocktailbar.domain.models.Cocktail
import com.example.cocktailbar.domain.repositories.StorageRepository

class GetCocktailUseCase(private val storageRepository: StorageRepository)  {

    suspend fun execute(id: Int): Cocktail = storageRepository.getCocktail(id)
}