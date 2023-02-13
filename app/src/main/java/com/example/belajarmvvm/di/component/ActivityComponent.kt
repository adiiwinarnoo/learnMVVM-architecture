package com.example.belajarmvvm.di.component

import dagger.Component
import com.example.belajarmvvm.di.ActivityScope
import com.example.belajarmvvm.di.module.ActivityModule
import com.example.belajarmvvm.ui.topheadline.TopHeadlineActivity
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: TopHeadlineActivity)
}