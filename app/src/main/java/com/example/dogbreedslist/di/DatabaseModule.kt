package com.example.dogbreedslist.di

import android.content.Context
import com.example.dogbreedslist.data.local.BreedsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = BreedsDatabase.getInstance(appContext)

    @Singleton
    @Provides
    fun provideBreedsDao(db: BreedsDatabase) = db.breedDao()
}
