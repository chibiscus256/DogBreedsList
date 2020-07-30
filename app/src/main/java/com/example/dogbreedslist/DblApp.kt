package com.example.dogbreedslist


import android.content.Context
import com.example.dogbreedslist.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

open class DblApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
/*        context = applicationContext
        initDagger()*/
    }

/*    open fun initDagger() {
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }*/

    companion object {
        lateinit var context: Context
    }
}