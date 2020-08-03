package com.example.dogbreedslist.breeds

import com.example.dogbreedslist.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface BreedListComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): BreedListComponent
    }

    // Classes that can be injected by this Component
    fun inject(fragment: DogsPhotosFragment)
    fun inject(fragment: SubbreedsListFragment)
}
