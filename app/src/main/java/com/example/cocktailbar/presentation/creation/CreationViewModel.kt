package com.example.cocktailbar.presentation.creation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailbar.domain.models.Cocktail
import com.example.cocktailbar.domain.storage.AddNewCocktailUseCase
import com.example.cocktailbar.domain.storage.EditCocktailUseCase
import com.example.cocktailbar.domain.storage.GetCocktailUseCase
import kotlinx.coroutines.launch

class CreationViewModel(
    private val addNewCocktailUseCase: AddNewCocktailUseCase,
    private val editCocktailUseCase: EditCocktailUseCase,
    private val getCocktailUseCase: GetCocktailUseCase
) : ViewModel() {


    private fun insertNewCocktail(cocktail: Cocktail) {
        viewModelScope.launch {
            addNewCocktailUseCase.execute(cocktail)
        }
    }

    fun addNewCocktail(
        name: String,
        description: String,
        ingredients: String,
        recipe: String
    ) {
        val newCocktail = Cocktail(
            id = 0,
            name = name,
            description = description,
            ingredients = ingredients,
            imageSrc = 0,
            recipe = recipe
        )
        insertNewCocktail(newCocktail)
    }

    fun isInputIsValid(
        name: String,
        ingredients: String,
    ) = (name.isNotBlank() && ingredients.isNotBlank())


}