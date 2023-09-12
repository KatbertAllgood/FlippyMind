package com.example.flippymind.di

import android.content.Context
import com.example.data.repository.MainDatabaseRepositoryImpl
import com.example.domain.repository.MainDatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    // all repos point there

    @Provides
    @Singleton // singleton - creates one time
    fun provideMainDatabaseRepository(
        @ApplicationContext context : Context
    ) : MainDatabaseRepository = MainDatabaseRepositoryImpl(context)
}