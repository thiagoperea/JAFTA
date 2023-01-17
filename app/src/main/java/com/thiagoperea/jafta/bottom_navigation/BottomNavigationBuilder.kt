package com.thiagoperea.jafta.bottom_navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.thiagoperea.jafta.JaftaNavigation
import com.thiagoperea.jafta.R
import com.thiagoperea.jafta.design_system.theme.TextStyles

/**
 * Configuring Bottom Bar icons and navigation.
 */

@Composable
fun RowScope.BottomItemHome(
    currentDestination: NavDestination?,
    navController: NavController
) {

    BottomNavigationItem(
        icon = {
            Icon(
                painter = painterResource(R.drawable.ic_home),
                contentDescription = null
            )
        },
        alwaysShowLabel = false,
        label = {
            Text(
                text = stringResource(R.string.home),
                style = TextStyles.medium10
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == JaftaNavigation.home } == true,
        onClick = {
            navController.navigate(JaftaNavigation.home) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}

@Composable
fun RowScope.BottomItemTransaction(
    currentDestination: NavDestination?,
    navController: NavController
) {

    BottomNavigationItem(
        icon = {
            Icon(
                painter = painterResource(R.drawable.ic_transaction),
                contentDescription = null
            )
        },
        alwaysShowLabel = false,
        label = {
            Text(
                text = stringResource(R.string.transaction),
                style = TextStyles.medium10
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == JaftaNavigation.homeTransaction } == true,
        onClick = {
//            navController.navigate(JaftaNavigation.homeTransaction) {
//                popUpTo(navController.graph.findStartDestination().id) {
//                    saveState = true
//                }
//                launchSingleTop = true
//                restoreState = true
//            }
        }
    )
}

@Composable
fun RowScope.BottomItemBudget(
    currentDestination: NavDestination?,
    navController: NavController
) {

    BottomNavigationItem(
        icon = {
            Icon(
                painter = painterResource(R.drawable.ic_pie_chart),
                contentDescription = null
            )
        },
        alwaysShowLabel = false,
        label = {
            Text(
                text = stringResource(R.string.budget),
                style = TextStyles.medium10
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == JaftaNavigation.homeBudget } == true,
        onClick = {
//            navController.navigate(JaftaNavigation.homeBudget) {
//                popUpTo(navController.graph.findStartDestination().id) {
//                    saveState = true
//                }
//                launchSingleTop = true
//                restoreState = true
//            }
        }
    )
}

@Composable
fun RowScope.BottomItemProfile(
    currentDestination: NavDestination?,
    navController: NavController
) {

    BottomNavigationItem(
        icon = {
            Icon(
                painter = painterResource(R.drawable.ic_profile),
                contentDescription = null
            )
        },
        alwaysShowLabel = false,
        label = {
            Text(
                text = stringResource(R.string.profile),
                style = TextStyles.medium10
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == JaftaNavigation.homeProfile } == true,
        onClick = {
//            navController.navigate(JaftaNavigation.homeProfile) {
//                popUpTo(navController.graph.findStartDestination().id) {
//                    saveState = true
//                }
//                launchSingleTop = true
//                restoreState = true
//            }
        }
    )
}