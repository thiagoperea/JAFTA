package com.thiagoperea.jafta.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thiagoperea.jafta.JaftaNavigation
import com.thiagoperea.jafta.transaction.ui.TransactionScreen

fun NavGraphBuilder.transactionNavigation(navController: NavController) {

    composable(JaftaNavigation.transaction) {

        TransactionScreen(
            onNavigateUp = { navController.navigateUp() }
        )
    }
}