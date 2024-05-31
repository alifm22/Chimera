package com.example.chimera.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

data class Strings(
    val txtNote: String = "Notes"
)

val LocalStrings =  compositionLocalOf { Strings() }

val MaterialTheme.strings: Strings
    @Composable
    @ReadOnlyComposable
    get() = LocalStrings.current