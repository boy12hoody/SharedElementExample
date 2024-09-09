package com.example.sharedelementexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sharedelementexample.ui.navigation.Home
import com.example.sharedelementexample.ui.navigation.Profile
import com.example.sharedelementexample.ui.screens.HomeScreen
import com.example.sharedelementexample.ui.screens.ProfileScreen
import com.example.sharedelementexample.ui.theme.OurComposeTheme
import com.example.sharedelementexample.util.ProvideAnimatedVisibilityScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OurComposeTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Home) {
                    composable<Home> {
                        // This one is to provide Navigation's AnimatedVisibilityScope to deeply nested hierarchy,
                        // so forgetting it will cause a crash when WithAnimatedVisibilityScope used in this screen
                        ProvideAnimatedVisibilityScope {
                            HomeScreen(
                                onNavigateToProfile = { navController.navigate(Profile) }
                            )
                        }
                    }
                    composable<Profile> {
                        ProvideAnimatedVisibilityScope {
                            ProfileScreen()
                        }
                    }
                }
            }
        }
    }
}
