package com.example.flippymind.screens.createnewdeck

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.InsertDeckUseCase
import com.example.flippymind.model.DeckPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateNewDeckVM @Inject constructor(
    private val insertDeckUseCase: InsertDeckUseCase
) : ViewModel() {

    private val TAG = CreateNewDeckVM::class.simpleName

    fun insertDeck(
        deck: DeckPresentation
    ) {
        viewModelScope.launch {
            insertDeckUseCase(deck)
        }
    }
}