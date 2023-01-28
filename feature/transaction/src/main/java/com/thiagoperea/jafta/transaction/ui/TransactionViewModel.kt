package com.thiagoperea.jafta.transaction.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoperea.jafta.design_system.dialog.DialogState
import com.thiagoperea.jafta.transaction.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {

    val screenState = mutableStateOf<TransactionState>(TransactionState.Loading)
    val dialogState = mutableStateOf<DialogState>(DialogState.Dismissed)

    var isRepeatingTransaction = mutableStateOf(false)
    var frequency: String? = null
    var endDate: String? = null

    fun loadScreen() {
        viewModelScope.launch {
            screenState.value = TransactionState.Loading

            /* TODO: load data if it is editing */

            screenState.value = TransactionState.NewEntry

            /* TODO: REMOVE */
            delay(2000L)
            dialogState.value = DialogState.Loading(R.string.saving_transaction)

            delay(3000L)
            dialogState.value = DialogState.Success(R.string.transaction_saved)

            delay(3000L)
            dialogState.value = DialogState.Failure(R.string.saving_transaction_error)

            delay(3000L)
            dialogState.value = DialogState.Dismissed
            /* TODO: REMOVE */
        }
    }

    fun saveTransaction() {
        viewModelScope.launch {
            dialogState.value = DialogState.Loading(R.string.saving_transaction)

            /* TODO: save transaction */

            dialogState.value = DialogState.Success(R.string.transaction_saved)
        }
    }
}

sealed class TransactionState {
    object Loading : TransactionState()

    object NewEntry : TransactionState()
}