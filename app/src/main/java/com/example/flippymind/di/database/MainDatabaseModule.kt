package com.example.flippymind.di.database

import com.example.domain.repository.MainDatabaseRepository
import com.example.domain.usecase.DeleteDeckUseCase
import com.example.domain.usecase.GetAllDecksUseCase
import com.example.domain.usecase.InsertDeckUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainDatabaseModule {

    @Provides
    fun providesGetAllDecksUseCase(
        repository: MainDatabaseRepository
    ) : GetAllDecksUseCase = GetAllDecksUseCase(repository)

    @Provides
    fun provideInsertDeck(
        repository: MainDatabaseRepository
    ) = InsertDeckUseCase(repository)

    @Provides
    fun provideDeleteDeck(
        repository: MainDatabaseRepository
    ) = DeleteDeckUseCase(repository)


}