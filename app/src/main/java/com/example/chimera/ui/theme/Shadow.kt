package com.example.chimera.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


data class Shadow(
    val small: Dp = 10.dp,
)

val LocalShadow =  compositionLocalOf { Shadow() }

val MaterialTheme.shadow: Shadow
    @Composable
    @ReadOnlyComposable
    get() = LocalShadow.current