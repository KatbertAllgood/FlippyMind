package com.example.domain.repository

import com.example.domain.models.DeckModelDomain
import kotlinx.coroutines.flow.Flow

interface MainDatabaseRepository {

    fun getAllDecks(): Flow<List<DeckModelDomain>>
}