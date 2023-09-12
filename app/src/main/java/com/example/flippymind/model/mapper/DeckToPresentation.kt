package com.example.flippymind.model.mapper

import com.example.domain.models.DeckDomain
import com.example.flippymind.model.DeckPresentation

class DeckToPresentation(
    private val deckDomain: DeckDomain
) {
    fun map(): DeckPresentation = DeckPresentation(
        deckDomain.id,
        deckDomain.name,
        deckDomain.cardsCount,
        deckDomain.color,
    )
}