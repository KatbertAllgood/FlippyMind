package com.example.domain.usecase

import com.example.domain.repository.MainDatabaseRepository

class GetAllDecksUseCase(
    private val mainDatabaseRepository: MainDatabaseRepository
) {
    operator fun invoke() = mainDatabaseRepository.getAllDecks()
}