package com.example.chimera.notes.presentation.screens.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import com.example.chimera.R
import com.example.chimera.notes.presentation.components.getOnColor
import com.example.chimera.notes.presentation.events.NoteDetailEvents
import com.example.chimera.ui.theme.border
import com.example.chimera.ui.theme.shadow
import com.example.chimera.ui.theme.values

@Composable
fun NoteColor(
    color: Int,
    onEvent: (NoteDetailEvents) -> Unit,
) {
    val colors = listOf<Int>(
        R.color.noteYellow,
        R.color.noteRed,
        R.color.noteViolet,
        R.color.noteBlue,
        R.color.noteGreen,
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        colors.forEach { colorId ->
            if (color == colorId) {
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = MaterialTheme.shadow.small,
                            shape = CircleShape
                        )
                        .size(MaterialTheme.values.noteColorPickerSize)
                        .clip(CircleShape)
                        .background(colorResource(id = colorId))
                        .border(
                            width = MaterialTheme.border.small,
                            shape = CircleShape,
                            color = colorResource(id = getOnColor(color = colorId))
                        )
                )
            } else {
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = MaterialTheme.shadow.small,
                            shape = CircleShape
                        )
                        .size(MaterialTheme.values.noteColorPickerSize)
                        .clip(CircleShape)
                        .background(colorResource(id = colorId))
                        .clickable {
                            onEvent(NoteDetailEvents.ColorChange(colorId))
                        }
                )
            }

        }
    }
}