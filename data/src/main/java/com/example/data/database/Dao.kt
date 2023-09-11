package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.models.DeckModelData
import com.example.domain.models.DeckModelDomain
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertDeck(deck: DeckModelData)

//    REPLACE above do same thing
//    @Update
//    suspend fun updateDeck(deck: DeckModelData)

    @Delete
    suspend fun deleteDeck(deck: DeckModelData)

    @Query("SELECT * FROM decks_table")
    fun getAllDecks(): Flow<List<DeckModelData>>

}