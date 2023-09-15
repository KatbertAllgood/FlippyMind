package com.example.flippymind.model

import com.example.domain.models.DeckDomain

data class DeckPresentation(
    override val id: Int? = null,
    override val name: String = "",
    override val cardsCount: Int = 0,
    override val color: String = ""
) : DeckDomain
