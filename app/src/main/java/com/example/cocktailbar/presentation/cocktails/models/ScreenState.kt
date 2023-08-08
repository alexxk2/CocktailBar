package com.example.cocktailbar.presentation.cocktails.models

sealed interface ScreenState{
    object Loading: ScreenState
    object Content: ScreenState
    object Error: ScreenState
    object Empty: ScreenState
}