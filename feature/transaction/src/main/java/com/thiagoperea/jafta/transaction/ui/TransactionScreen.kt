package com.thiagoperea.jafta.transaction.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.thiagoperea.jafta.design_system.LoadingScreen
import com.thiagoperea.jafta.transaction.ui.type.TransactionScreenType
import org.koin.androidx.compose.koinViewModel

@Composable
fun TransactionScreen(
    viewModel: TransactionViewModel = koinViewModel(),
    onNavigateUp: () -> Unit
) {
    val screenState = viewModel.screenState.value

    LaunchedEffect(Unit) {
        viewModel.loadScreen()
    }

    when (screenState) {
        is TransactionState.Loading -> LoadingScreen()
        is TransactionState.NewExpense -> {
            TransactionScreenContent(
                type = TransactionScreenType.EXPENSE,
                onNavigateUp = onNavigateUp,
            )
        }
        is TransactionState.NewIncome -> {
            TransactionScreenContent(
                type = TransactionScreenType.INCOME,
                onNavigateUp = onNavigateUp,
            )
        }
    }
}