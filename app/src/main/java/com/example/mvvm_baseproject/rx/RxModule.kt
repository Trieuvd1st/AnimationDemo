package com.example.mvvm_baseproject.rx

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RxModule {
    @Provides
    @Singleton
    fun provideRxSchedulers(): RxSchedulers {
        return AppRxSchedulers()
    }
}