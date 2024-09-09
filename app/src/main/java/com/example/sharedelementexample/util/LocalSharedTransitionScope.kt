package com.example.sharedelementexample.util

import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope> {
    error("Must be provided first")
}

@Composable
fun SharedTransitionScope.ProvideSharedTransitionScope(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSharedTransitionScope provides this,
        content = content
    )
}

@Composable
fun WithSharedTransitionScope(block: @Composable SharedTransitionScope.() -> Unit) {
    with(LocalSharedTransitionScope.current) {
        block()
    }
}
