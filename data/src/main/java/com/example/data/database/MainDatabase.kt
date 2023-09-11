package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.models.DeckModelData

@Database(
    entities = [ // here is points @Entity (tables), which should be in database
        DeckModelData::class
    ],
    version = 1
)
abstract class MainDatabase : RoomDatabase() {

    companion object {
        fun createDatabase(
            context: Context
        ) : MainDatabase {
            return Room.databaseBuilder(
                context,
                MainDatabase::class.java,
                "flippymind.db"
            ).build()
        }
    }
}