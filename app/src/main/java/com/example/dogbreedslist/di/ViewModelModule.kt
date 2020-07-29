package com.example.dogbreedslist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dogbreedslist.viewmodel.BreedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BreedViewModel::class)
    abstract fun bindBreedListViewModel(breedListViewModel: BreedViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DblViewModelFactory): ViewModelProvider.Factory
}
