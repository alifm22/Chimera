package com.example.chimera.notes.presentation.screens.note_screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.chimera.notes.presentation.events.NoteEvents
import com.example.chimera.notes.presentation.screens.note_screen.NotesState
import com.example.chimera.ui.theme.spacing
import com.example.chimera.ui.theme.strings
import com.example.chimera.ui.theme.values

@Composable
fun NoteTopBar(
    modifier: Modifier = Modifier,
    noteState: NotesState,
    onEvent: (NoteEvents) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.outlineVariant)
            .padding(
                horizontal = MaterialTheme.spacing.medium,
                vertical = MaterialTheme.spacing.small
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = modifier
                .padding(horizontal = MaterialTheme.spacing.xSmall)
                .size(MaterialTheme.values.smallIconSize),
            imageVector = Icons.Default.Notes,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = MaterialTheme.strings.txtNote,
            modifier = modifier
                .background(MaterialTheme.colorScheme.outlineVariant),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(
            modifier = modifier
                .weight(1f)
        )
        IconButton(
            onClick = { onEvent(NoteEvents.ToggleFilter) },
        ) {
            Icon(
                modifier = modifier
                    .size(MaterialTheme.values.smallIconSize),
                imageVector = Icons.Default.FilterList,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
    AnimatedVisibility(
        visible = noteState.isFilterVisible,
        enter = fadeIn() + slideInVertically(),
        exit = fadeOut() + slideOutVertically()
    ) {
        NoteFilter(
            noteState = noteState,
            onEvent = onEvent
        )
    }
}