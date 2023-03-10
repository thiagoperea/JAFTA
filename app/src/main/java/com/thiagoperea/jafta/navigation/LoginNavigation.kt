package com.thiagoperea.jafta.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thiagoperea.jafta.JaftaNavigation
import com.thiagoperea.jafta.login.ui.login.LoginScreen
import com.thiagoperea.jafta.login.ui.onboarding.OnboardingScreen
import com.thiagoperea.jafta.login.ui.signup.SignupScreen

fun NavGraphBuilder.loginNavigation(navController: NavController) {

    composable(JaftaNavigation.onboarding) {
        OnboardingScreen(
            goToSignup = {
                navController.navigate(JaftaNavigation.signUp)
            },
            goToLogin = {
                navController.navigate(JaftaNavigation.login)
            }
        )
    }

    composable(JaftaNavigation.signUp) {
        SignupScreen(
            onNavigationUp = { navController.navigateUp() }
        )
    }

    composable(JaftaNavigation.login) {
        LoginScreen(
            onNavigationUp = { navController.navigateUp() },
            goToHome = {
                navController.navigate(JaftaNavigation.home) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}