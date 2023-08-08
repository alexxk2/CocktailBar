package com.example.cocktailbar.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailbar.domain.models.Cocktail
import com.example.cocktailbar.domain.storage.DeleteCocktailUseCase
import kotlinx.coroutines.launch

class DetailsViewModel(

    private val deleteCocktailUseCase: DeleteCocktailUseCase

): ViewModel() {


    fun deleteCocktail(cocktail: Cocktail){
        viewModelScope.launch {
            deleteCocktailUseCase.execute(cocktail)
        }
    }

}