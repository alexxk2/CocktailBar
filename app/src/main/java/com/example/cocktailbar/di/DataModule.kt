package com.example.cocktailbar.di

import com.example.cocktailbar.data.db.CocktailsDatabase
import com.example.cocktailbar.data.db.RoomStorage
import com.example.cocktailbar.data.db.impl.RoomStorageImpl
import com.example.cocktailbar.data.repositories.StorageRepositoryImpl
import com.example.cocktailbar.domain.repositories.StorageRepository
import org.koin.dsl.module

val dataModule = module {

    single<RoomStorage> { RoomStorageImpl(cocktailsDatabase = get()) }

    single<StorageRepository> { StorageRepositoryImpl(roomStorage = get()) }

    single<CocktailsDatabase> { CocktailsDatabase.getDataBase(context = get()) }
}