package com.example.cocktailbar.di

import com.example.cocktailbar.domain.storage.AddNewCocktailUseCase
import com.example.cocktailbar.domain.storage.DeleteCocktailUseCase
import com.example.cocktailbar.domain.storage.EditCocktailUseCase
import com.example.cocktailbar.domain.storage.GetAllCocktailsUseCase
import com.example.cocktailbar.domain.storage.GetCocktailUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<AddNewCocktailUseCase> { AddNewCocktailUseCase(storageRepository = get()) }
    factory<DeleteCocktailUseCase> { DeleteCocktailUseCase(storageRepository = get()) }
    factory<EditCocktailUseCase> { EditCocktailUseCase(storageRepository = get()) }
    factory<GetAllCocktailsUseCase> { GetAllCocktailsUseCase(storageRepository = get()) }
    factory<GetCocktailUseCase> { GetCocktailUseCase(storageRepository = get()) }
}