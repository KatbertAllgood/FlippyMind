package com.example.domain.usecase

import com.example.domain.models.DeckDomain
import com.example.domain.repository.MainDatabaseRepository

class DeleteDeckUseCase(
    private val mainDatabaseRepository: MainDatabaseRepository
) {
    suspend operator fun invoke(
        deck: DeckDomain
    ) = mainDatabaseRepository.deleteDeck(deck)
}