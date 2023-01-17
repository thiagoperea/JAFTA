package com.thiagoperea.jafta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.thiagoperea.jafta.bottom_navigation.BottomItemBudget
import com.thiagoperea.jafta.bottom_navigation.BottomItemHome
import com.thiagoperea.jafta.bottom_navigation.BottomItemProfile
import com.thiagoperea.jafta.bottom_navigation.BottomItemTransaction
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Light80
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.extension.containsAny
import com.thiagoperea.jafta.navigation.homeNavigation
import com.thiagoperea.jafta.navigation.loginNavigation
import com.thiagoperea.jafta.navigation.transactionNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            /*
                - Create MainScreen, MainScreenContent and MainViewModel
                - hoist states there
            */

            val navController = rememberNavController()
            val showHomeControllers = remember { mutableStateOf(false) }

            val navBackStackEntry = navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry.value?.destination

            LaunchedEffect(Unit) {

                navController.addOnDestinationChangedListener { _, destination, _ ->
                    showHomeControllers.value = destination.route.containsAny(
                        JaftaNavigation.home,
                        JaftaNavigation.homeTransaction,
                        JaftaNavigation.homeBudget,
                        JaftaNavigation.homeProfile
                    )
                }
            }

            JAFTATheme(
                darkTheme = false
            ) {
                Scaffold(
                    bottomBar = {
                        if (showHomeControllers.value) {
                            BottomAppBar(
                                cutoutShape = CircleShape,
                                backgroundColor = Light80,
                                contentColor = Violet100,
                            ) {

                                BottomItemHome(
                                    currentDestination = currentDestination,
                                    navController = navController
                                )

                                BottomItemTransaction(
                                    currentDestination = currentDestination,
                                    navController = navController
                                )

                                Spacer(Modifier.weight(1f))

                                BottomItemBudget(
                                    currentDestination = currentDestination,
                                    navController = navController
                                )

                                BottomItemProfile(
                                    currentDestination = currentDestination,
                                    navController = navController
                                )
                            }
                        }
                    },
                    floatingActionButton = {

                        if (showHomeControllers.value) {
                            FloatingActionButton(
                                onClick = {
                                    navController.navigate(JaftaNavigation.transaction)
                                },
                                backgroundColor = Violet100,
                                contentColor = Light80,

                                ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButtonPosition = FabPosition.Center
                ) { padding ->

                    NavHost(
                        modifier = Modifier.padding(padding),
                        navController = navController,
                        startDestination = JaftaNavigation.onboarding
                    ) {
                        /*
                            - first screen -> SplashScreen

                            - if user logged    -> pin / fingerprint
                                  - else        -> onboarding
                        */

                        loginNavigation(navController)

                        homeNavigation(navController)

                        transactionNavigation(navController)
                    }
                }
            }
        }
    }
}