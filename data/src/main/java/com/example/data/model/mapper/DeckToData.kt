package com.example.data.model.mapper

import com.example.data.model.DeckData
import com.example.domain.models.DeckDomain

class DeckToData(
    private val deckDomain: DeckDomain
) {

    fun map() : DeckData = DeckData(
        deckDomain.id,
        deckDomain.name,
        deckDomain.cardsCount,
        deckDomain.color,
    )
}