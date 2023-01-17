package com.thiagoperea.jafta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.navigation.homeNavigation
import com.thiagoperea.jafta.navigation.loginNavigation

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

            JAFTATheme(
                darkTheme = false
            ) {

                Scaffold(
                    bottomBar = {
                        if (showHomeControllers.value) {
                            BottomAppBar(
                                cutoutShape = CircleShape
                            ) {

                            }
                        }
                    },
                    floatingActionButton = {
                        if (showHomeControllers.value) {
                            FloatingActionButton(onClick = {}) {
                                Icon(Icons.Default.Add, null)
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

                        homeNavigation(navController, onHomeItemSelected = { showHomeControllers.value = true })

                    }
                }
            }
        }
    }
}