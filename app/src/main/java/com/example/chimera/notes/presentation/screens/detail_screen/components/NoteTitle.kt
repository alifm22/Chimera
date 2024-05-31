package com.example.chimera.notes.presentation.screens.detail_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.chimera.notes.presentation.components.getOnColor
import com.example.chimera.notes.presentation.events.NoteDetailEvents
import com.example.chimera.notes.presentation.screens.detail_screen.NoteDetailState
import com.example.chimera.ui.theme.spacing

@Composable
fun NoteTitle(
    noteDetailState: NoteDetailState,
    isTitle: Boolean,
    text: String,
    color: Int,
    isEditMode: Boolean? = true,
    isBookmarked: Boolean = false,
    onEvent: (NoteDetailEvents) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MaterialTheme.spacing.medium
            )
    ) {
        Column (
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ){
            NoteTextField(
                modifier = Modifier.fillMaxWidth(),
                value = noteDetailState.title,
                label = "Title...",
                color = noteDetailState.color,
                isBold = true,
                isEditable = isEditMode,
                isTitle = isTitle,
                onEvent = onEvent,
//                onValueChange = onEvent(NoteDetailEvents.TitleChange(noteDetailState.title))
            )
        }

        Column (
            modifier = Modifier
                .padding(
                    vertical = MaterialTheme.spacing.xSmall,
                    horizontal = MaterialTheme.spacing.small
                )
                .width(30.dp),
            verticalArrangement = Arrangement.Center
        ){
            IconButton(
                onClick = { onEvent(NoteDetailEvents.ToggleBookmark) }
            ) {
                val icon = if (isBookmarked) Icons.Default.Bookmark
                else Icons.Default.BookmarkBorder
                Icon(
                    modifier = Modifier
                        .size(30.dp),
                    imageVector = icon,
                    contentDescription = "bookmark",
                    tint = colorResource(id = getOnColor(color = color))
                )
            }
        }
    }
}