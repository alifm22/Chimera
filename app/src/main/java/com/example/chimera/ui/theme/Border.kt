package com.example.chimera.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


data class Border(
    val small: Dp = 4.dp,
)

val LocalBorder =  compositionLocalOf { Border() }

val MaterialTheme.border: Border
    @Composable
    @ReadOnlyComposable
    get() = LocalBorder.current