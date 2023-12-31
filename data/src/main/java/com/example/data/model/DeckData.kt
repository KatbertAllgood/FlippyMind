package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.DeckDomain

@Entity(
    tableName = "decks_table"
) // table would named like this data class if "tableName" disabled
data class DeckData(
    @PrimaryKey(autoGenerate = true)
    override val id: Int? = null,
    // @ColumnInfo(name = "bla-bla-bla") maybe if I want custom name of column in table
    override val name: String = "",
    override val cardsCount: Int = 0,
    override val color: String = ""
) : DeckDomain
