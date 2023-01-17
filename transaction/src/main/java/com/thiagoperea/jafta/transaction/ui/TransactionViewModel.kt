package com.thiagoperea.jafta.transaction.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel() {

    val screenState = mutableStateOf<TransactionState>(TransactionState.Loading)
}

sealed class TransactionState {
    object Loading : TransactionState()
}