package com.example.domain.repository

import com.example.domain.models.DeckDomain
import kotlinx.coroutines.flow.Flow

interface MainDatabaseRepository {

    fun getAllDecks(): Flow<List<DeckDomain>>

    suspend fun insertDeck(deck: DeckDomain)

    suspend fun deleteDeck(deck: DeckDomain)
}