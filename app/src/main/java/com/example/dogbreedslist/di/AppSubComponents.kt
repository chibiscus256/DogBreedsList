package com.example.dogbreedslist.di

import com.example.dogbreedslist.breeds.BreedsComponent
import com.example.dogbreedslist.favorites.FavoritesComponent
import dagger.Module

@Module(
    subcomponents = [
        FavoritesComponent::class,
        BreedsComponent::class
    ]
)
class AppSubComponents

