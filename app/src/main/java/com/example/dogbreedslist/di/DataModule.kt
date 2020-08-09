package com.example.dogbreedslist.di

import com.example.dogbreedslist.data.DataRepository
import com.example.dogbreedslist.data.local.LocalData
import com.example.dogbreedslist.data.network.RemoteData
import com.example.dogbreedslist.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: RemoteData,
                          localDataSource: LocalData) =
        DataRepository(remoteDataSource, localDataSource)
}