package com.thiagoperea.jafta.transaction.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
class TransactionViewModel : ViewModel() {

    val screenState = mutableStateOf<TransactionState>(TransactionState.Loading)


    val isRepeatingTransaction = mutableStateOf(false)

    fun loadScreen() {
        viewModelScope.launch {
            screenState.value = TransactionState.Loading

            //TODO: get last transaction screen

            screenState.value = TransactionState.NewEntry
        }
    }
}

sealed class TransactionState {
    object Loading : TransactionState()

    object NewEntry : TransactionState()
}