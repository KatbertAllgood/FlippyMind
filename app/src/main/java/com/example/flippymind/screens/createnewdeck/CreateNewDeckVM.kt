package com.example.flippymind.screens.createnewdeck

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.InsertDeckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateNewDeckVM @Inject constructor(
    private val insertDeckUseCase: InsertDeckUseCase
) : ViewModel() {

    private val TAG = CreateNewDeckVM::class.simpleName



}