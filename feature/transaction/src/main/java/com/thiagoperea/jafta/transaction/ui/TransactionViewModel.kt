package com.thiagoperea.jafta.transaction.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {

    val screenState = mutableStateOf<TransactionState>(TransactionState.Loading)

    fun loadScreen() {
        viewModelScope.launch {
            screenState.value = TransactionState.Loading

            //TODO: get last transaction screen

            screenState.value = TransactionState.NewIncome
        }
    }
}

sealed class TransactionState {
    object Loading : TransactionState()

    object NewIncome : TransactionState()

    object NewExpense : TransactionState()
}