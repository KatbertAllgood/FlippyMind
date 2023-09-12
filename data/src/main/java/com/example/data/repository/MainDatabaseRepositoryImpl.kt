package com.example.data.repository

import android.content.Context
import androidx.room.Room
import com.example.data.database.MainDatabase
import com.example.domain.models.DeckModelDomain
import com.example.domain.repository.MainDatabaseRepository
import kotlinx.coroutines.flow.Flow

class MainDatabaseRepositoryImpl(
    context: Context
) : MainDatabaseRepository {

    private val database = Room.databaseBuilder(
        context,
        MainDatabase::class.java, "database-name"
    ).build()

    override fun getAllDecks(): Flow<List<DeckModelDomain>> {
        return database.deckDao().getAllDecks()
    }
}