package com.example.flippymind.model.mapper

import com.example.domain.models.DeckDomain
import com.example.flippymind.model.DeckPresentation

class ListDeckToPresentation(
    private val list: List<DeckDomain>
) {
    fun map() : List<DeckPresentation> {
        val newList: MutableList<DeckPresentation> = mutableListOf()
        for (i in list) newList.add(DeckToPresentation(i).map())
        return newList
    }
}