package com.thiagoperea.jafta.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thiagoperea.jafta.JaftaNavigation
import com.thiagoperea.jafta.transaction.ui.TransactionScreen
import com.thiagoperea.jafta.transaction.ui.type.TransactionScreenType

fun NavGraphBuilder.transactionNavigation(navController: NavController) {

    composable(JaftaNavigation.transaction) {

        /* TODO: Create another composable to handle INCOME type */

        TransactionScreen(
            onNavigateUp = { navController.navigateUp() },
            screenType = TransactionScreenType.EXPENSE
        )
    }
}