package com.example.chimera.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Values(
    val peekHeight: Dp = 140.dp,
    val notesGridColumnCount: Int = 2,
    val smallIconSize: Dp = 30.dp,
    val cornerRadius: Dp = 10.dp,
    val cutCornerSize: Dp = 30.dp,
    val noteColorPickerSize: Dp = 50.dp
)

val LocalValues =  compositionLocalOf { Values() }

val MaterialTheme.values: Values
    @Composable
    @ReadOnlyComposable
    get() = LocalValues.current