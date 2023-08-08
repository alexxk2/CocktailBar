package com.example.cocktailbar.presentation.cocktails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktailbar.domain.models.Cocktail
import com.example.cocktailbar.domain.storage.AddNewCocktailUseCase
import com.example.cocktailbar.domain.storage.GetAllCocktailsUseCase
import com.example.cocktailbar.presentation.cocktails.models.ScreenState

class CocktailsViewModel(
    private val getAllCocktailsUseCase: GetAllCocktailsUseCase,
    private val addNewCocktailUseCase: AddNewCocktailUseCase
): ViewModel() {

    private val _screenState = MutableLiveData<ScreenState>()
    val screenState: LiveData<ScreenState> = _screenState

    private val _cocktailsList = MutableLiveData<List<Cocktail>>()
    val cocktailsList: LiveData<List<Cocktail>> = _cocktailsList


}