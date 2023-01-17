package com.thiagoperea.jafta.transaction.di

import com.thiagoperea.jafta.transaction.ui.TransactionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val transactionModule = module {

    viewModel { TransactionViewModel() }
}