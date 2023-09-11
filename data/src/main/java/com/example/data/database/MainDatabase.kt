package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.models.DeckModelData

@Database(
    entities = [ // here is points @Entity (tables), wich should be in database
        DeckModelData::class
    ],
    version = 1
)
abstract class MainDatabase : RoomDatabase() {

}