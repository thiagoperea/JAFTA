package com.thiagoperea.jafta.transaction.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Light80
import com.thiagoperea.jafta.design_system.theme.Violet100
import org.koin.androidx.compose.koinViewModel

@Composable
fun TransactionScreen(
    viewModel: TransactionViewModel = koinViewModel(),
    onNavigateUp: () -> Unit
) {

    val screenState = viewModel.screenState.value

    when (screenState) {
        TransactionState.Loading -> LoadingScreen()
    }
}

@Composable
fun LoadingScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Light80.copy(alpha = 0.3f)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = Violet100
        )
    }
}
