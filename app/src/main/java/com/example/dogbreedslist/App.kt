package com.example.dogbreedslist

import android.app.Application
import android.content.Context
import com.example.dogbreedslist.di.AppComponent
import com.example.dogbreedslist.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initDagger()
    }

    open fun initDagger() {
        DaggerAppComponent.builder().build().inject(this)
    }

    companion object {
        lateinit var context: Context
    }
}