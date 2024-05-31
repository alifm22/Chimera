package com.example.chimera.notes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.chimera.R

@Composable
fun getOnColor(color: Int): Int {
    return when (color) {
        R.color.noteGreen -> R.color.onNoteGreen
        R.color.noteRed -> R.color.onNoteRed
        R.color.noteYellow -> R.color.onNoteYellow
        R.color.noteBlue -> R.color.onNoteBlue
        R.color.noteViolet -> R.color.onNoteViolet
        else -> {
            R.color.noteYellow
        }
    }
}

@Composable
fun GradientLine(
    width: Dp = 0.dp,
    height: Dp = 0.dp,
    colors: List<Color>,
) {
    Box(
        modifier = Modifier
            .size(
                width = width,
                height = height
            )
            .background(
                brush = Brush.verticalGradient(colors)
            )
    )
}