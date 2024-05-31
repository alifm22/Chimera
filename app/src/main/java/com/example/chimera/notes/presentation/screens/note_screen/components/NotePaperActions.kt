package com.example.chimera.notes.presentation.screens.note_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chimera.core.domain.Screen
import com.example.chimera.notes.data.local.model.Note
import com.example.chimera.notes.presentation.components.GradientLine
import com.example.chimera.notes.presentation.components.getOnColor
import com.example.chimera.notes.presentation.events.NoteEvents

@Composable
fun NotePaperActionBar(
    navController: NavController,
    note: Note,
    onEvent: (NoteEvents) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            onEvent(NoteEvents.DeleteNote(note))
        }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = colorResource(id = getOnColor(note.color))
            )
        }
        GradientLine(
            width = 1.dp,
            height = 30.dp,
            colors = listOf(
                Color.Transparent,
                colorResource(id = getOnColor(color = note.color)),
                Color.Transparent
            )
        )
        IconButton(onClick = {
            onEvent(NoteEvents.ToggleBookmark(note))
        }) {
            val icon = if (note.isBookmarked) Icons.Default.Bookmark
            else Icons.Default.BookmarkBorder
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = colorResource(id = getOnColor(note.color))
            )
        }
        GradientLine(
            width = 1.dp,
            height = 30.dp,
            colors = listOf(
                Color.Transparent,
                colorResource(id = getOnColor(color = note.color)),
                Color.Transparent
            )
        )
        IconButton(
            onClick = {
                navController.navigate(
                    "${Screen.NoteDetailScreen.route}?id=${note.id}?edit=${true}"
                )
            }) {
            Icon(
                imageVector = Icons.Default.EditNote,
                contentDescription = null,
                tint = colorResource(id = getOnColor(note.color))
            )
        }

    }
}