package com.example.dogbreedslist.favorites

import com.example.dogbreedslist.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface FavoritesComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(): FavoritesComponent
    }

    fun inject(activity: FavoritesActivity)
}