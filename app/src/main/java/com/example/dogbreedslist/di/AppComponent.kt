package com.example.dogbreedslist.di

import android.content.Context
import com.example.dogbreedslist.DblApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        ErrorModule::class
    ]
)
interface AppComponent : AndroidInjector<DblApp>{

    override fun inject(dblApp: DblApp)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}