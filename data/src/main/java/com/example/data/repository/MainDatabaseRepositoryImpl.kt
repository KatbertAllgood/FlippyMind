package com.example.data.repository

import android.content.Context
import androidx.room.Room
import com.example.data.database.MainDatabase
import com.example.data.model.mapper.DeckToData
import com.example.domain.models.DeckDomain
import com.example.domain.repository.MainDatabaseRepository
import kotlinx.coroutines.flow.Flow

class MainDatabaseRepositoryImpl(
    context: Context
) : MainDatabaseRepository {

    private val database = Room.databaseBuilder(
        context,
        MainDatabase::class.java, "database-name"
    ).build()

    override fun getAllDecks(): Flow<List<DeckDomain>> {
        return database.deckDao().getAllDecks()
    }

    override suspend fun insertDeck(deck: DeckDomain) {
        return database.deckDao().insertDeck(
            DeckToData(deck).map()
        )
    }

    override suspend fun deleteDeck(deck: DeckDomain) {
        return database.deckDao().deleteDeck(
            DeckToData(deck).map()
        )
    }
}