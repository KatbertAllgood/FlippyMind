package com.example.flippymind.model

import com.example.domain.models.DeckModelDomain

data class DeckModelPresentation(
    override val id: Int? = null,
    override val name: String,
    override val cardsCount: Int,
    override val color: Long
) : DeckModelDomain
