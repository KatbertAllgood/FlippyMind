package com.example.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "decks_table"
) // table would named like this data class if "tableName" disabled
data class DeckModelData(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    // @ColumnInfo(name = "bla-bla-bla") maybe if I want custom name of column in table
    val name: String = "",
    val cardsCount: Int = 0,
    val color: Long = 0
)
