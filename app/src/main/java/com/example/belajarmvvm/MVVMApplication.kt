package com.example.belajarmvvm

import android.app.Application
import com.example.belajarmvvm.di.component.ApplicationComponent
import com.example.belajarmvvm.di.component.DaggerApplicationComponent
import com.example.belajarmvvm.di.module.ApplicationModule


class MVVMApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }


    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}