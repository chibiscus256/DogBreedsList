package com.example.dogbreedslist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dogbreedslist.ui.breeds.BreedListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BreedListViewModel::class)
    abstract fun bindBreedListViewModel(breedListListViewModel: BreedListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DblViewModelFactory): ViewModelProvider.Factory
}
