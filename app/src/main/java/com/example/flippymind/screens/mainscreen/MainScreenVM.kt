package com.example.flippymind.screens.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetAllDecksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val getAllDecksUseCase: GetAllDecksUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {

            getAllDecksUseCase().flowOn(Dispatchers.IO).catch {

            }.map {

            }.collect {

            }
        }
    }
}