package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.DeckData

@Database(
    entities = [ // here is points @Entity (tables), which should be in database
        DeckData::class
    ],
    version = 1
)
abstract class MainDatabase : RoomDatabase() {

    //here only dao
    abstract fun deckDao() : DeckDao
}