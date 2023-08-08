package com.example.cocktailbar.di

import com.example.cocktailbar.presentation.cocktails.CocktailsViewModel
import com.example.cocktailbar.presentation.creation.CreationViewModel
import com.example.cocktailbar.presentation.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<CocktailsViewModel> {
        CocktailsViewModel(
            getAllCocktailsUseCase = get(),
            addNewCocktailUseCase = get()
        )
    }

    viewModel<CreationViewModel> {
        CreationViewModel(
            getCocktailUseCase = get(),
            addNewCocktailUseCase = get(),
            editCocktailUseCase = get()
        )
    }

    viewModel<DetailsViewModel> { DetailsViewModel(deleteCocktailUseCase = get()) }
}