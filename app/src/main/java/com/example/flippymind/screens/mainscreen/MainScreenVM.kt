package com.example.flippymind.screens.mainscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DeleteDeckUseCase
import com.example.domain.usecase.GetAllDecksUseCase
import com.example.domain.usecase.InsertDeckUseCase
import com.example.flippymind.model.DeckPresentation
import com.example.flippymind.model.mapper.ListDeckToPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val getAllDecksUseCase: GetAllDecksUseCase,
    private val insertDeckUseCase: InsertDeckUseCase,
    private val deleteDeckUseCase: DeleteDeckUseCase
) : ViewModel() {

    private val TAG = MainScreenVM::class.simpleName

    fun getAddDecks() {

        viewModelScope.launch {

            getAllDecksUseCase().flowOn(Dispatchers.IO).catch {
                Log.d(TAG, "GET_ALL_DECKS_ERROR: " + it.message)
            }.map {
                ListDeckToPresentation(it)
            }.collect {
                Log.d(TAG, "GET_ALL_DECKS_SUCCESS: $it")
            }
        }
    }

    fun insertDeck(
        deck: DeckPresentation
    ) {
        viewModelScope.launch {
            insertDeckUseCase(deck)
        }
    }

    fun deleteDeck(
        deck: DeckPresentation
    ) {
        viewModelScope.launch {
            deleteDeckUseCase(deck)
        }
    }

}