package com.example.dogbreedslist.di

import com.example.dogbreedslist.breeds.BreedListComponent
import com.example.dogbreedslist.favorites.FavoritesComponent
import dagger.Module

@Module(
    subcomponents = [
        FavoritesComponent::class,
        BreedListComponent::class
    ]
)
class AppSubComponents

