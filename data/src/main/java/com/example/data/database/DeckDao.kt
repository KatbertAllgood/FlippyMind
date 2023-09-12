package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.models.DeckData
import kotlinx.coroutines.flow.Flow

@Dao
interface DeckDao {
    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertDeck(deck: DeckData)

//    REPLACE above do same thing
//    @Update
//    suspend fun updateDeck(deck: DeckModelData)

    @Delete
    suspend fun deleteDeck(deck: DeckData)

    @Query("SELECT * FROM decks_table")
    fun getAllDecks(): Flow<List<DeckData>>

}