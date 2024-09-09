package com.example.sharedelementexample.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sharedelementexample.ui.theme.OurComposeTheme
import com.example.sharedelementexample.util.WithAnimatedVisibilityScope
import com.example.sharedelementexample.util.WithSharedTransitionScope

@Composable
fun HomeScreen(
    onNavigateToProfile: () -> Unit
) {
    // VM,DI stuff
    ScreenContent(
        onNavigateToProfile = onNavigateToProfile
    )
}

@Composable
private fun ScreenContent(
    onNavigateToProfile: () -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Some content to be shared across screens
            WithSharedTransitionScope {
                WithAnimatedVisibilityScope {
                    Box(
                        modifier = Modifier
                            .sharedElement(
                                state = rememberSharedContentState(key = "shared_content_key"),
                                animatedVisibilityScope = this
                            )
                            .background(Color.Red)
                            .size(100.dp)

                    )
                }
            }
            Button(onNavigateToProfile) {
                Text("Go to Profile")
            }
        }
    }
}

@Preview
@Composable
private fun ScreenContentPreview() = OurComposeTheme {
    ScreenContent(
        onNavigateToProfile = {}
    )
}