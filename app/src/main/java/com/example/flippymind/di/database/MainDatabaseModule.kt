package com.example.flippymind.di.database

import com.example.domain.repository.MainDatabaseRepository
import com.example.domain.usecase.GetAllDecksUseCase
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
}