package com.thiagoperea.jafta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.thiagoperea.jafta.navigation.loginNavigation
import com.thiagoperea.jafta.design_system.theme.JAFTATheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            JAFTATheme {

                NavHost(
                    navController = navController,
                    startDestination = JaftaNavigation.onboarding
                ) {

                    loginNavigation(navController)


                }
                /*

                    - create NavHost
                    - import navigation from each module

                    - first screen -> SplashScreen

                    - if user logged    -> pin / fingerprint
                          - else        -> onboarding

                */
            }
        }
    }
}