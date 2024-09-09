package com.example.sharedelementexample.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
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
fun ProfileScreen() {
    // VM,DI stuff
    ScreenContent()
}

@Composable
private fun ScreenContent() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // The content that is shared from previous screen
            WithSharedTransitionScope {
                WithAnimatedVisibilityScope {
                    Box(
                        modifier = Modifier
                            .sharedElement(
                                state = rememberSharedContentState(key = "shared_content_key"),
                                animatedVisibilityScope = this
                            )
                            .background(Color.Red)
                            .size(300.dp)

                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ScreenContentPreview() = OurComposeTheme {
    ScreenContent()
}