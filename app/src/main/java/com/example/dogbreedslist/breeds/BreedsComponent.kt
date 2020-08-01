package com.example.dogbreedslist.breeds

import com.example.dogbreedslist.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface BreedsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): BreedsComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: BreedsListActivity)
}
