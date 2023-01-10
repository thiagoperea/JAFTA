package com.thiagoperea.jafta.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thiagoperea.jafta.JaftaNavigation
import com.thiagoperea.jafta.home.ui.HomeScreen

fun NavGraphBuilder.homeNavigation(
    navController: NavController,
    onHomeItemSelected: () -> Unit
) {

    composable(JaftaNavigation.home) {
        onHomeItemSelected()

        HomeScreen()
    }

}