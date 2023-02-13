package com.example.belajarmvvm.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarmvvm.data.repository.TopHeadlineRepository
import com.example.belajarmvvm.di.ActivityContext
import dagger.Module
import dagger.Provides
import androidx.lifecycle.ViewModelProvider
import com.example.belajarmvvm.ui.base.ViewModelProviderFactory
import com.example.belajarmvvm.ui.topheadline.TopHeadlineAdapter
import com.example.belajarmvvm.ui.topheadline.TopHeadlineViewModel
import javax.inject.Singleton

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())
}