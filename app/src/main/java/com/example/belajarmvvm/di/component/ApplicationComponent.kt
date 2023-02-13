package com.example.belajarmvvm.di.component

import android.content.Context
import com.example.belajarmvvm.MVVMApplication
import com.example.belajarmvvm.data.api.NetworkService
import com.example.belajarmvvm.data.repository.TopHeadlineRepository
import com.example.belajarmvvm.di.ApplicationContext
import com.example.belajarmvvm.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])

interface ApplicationComponent {

    fun inject(application: MVVMApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository
}