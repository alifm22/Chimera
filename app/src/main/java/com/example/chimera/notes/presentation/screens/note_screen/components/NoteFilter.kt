package com.example.chimera.notes.presentation.screens.note_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chimera.notes.domain.util.NoteOrder
import com.example.chimera.notes.presentation.components.DefaultRadioButton
import com.example.chimera.notes.presentation.events.NoteEvents
import com.example.chimera.notes.presentation.screens.note_screen.NotesState
import com.example.chimera.ui.theme.spacing

@Composable
fun NoteFilter(
    modifier: Modifier = Modifier,
    noteState: NotesState,
    onEvent: (NoteEvents) -> Unit
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column (
            modifier = Modifier
                .weight(1f)
                .padding(
                    horizontal = MaterialTheme.spacing.small
                )
        ){
            Row {
                DefaultRadioButton(
                    text = "Date",
                    selected = noteState.noteOrder is NoteOrder.Date,
                    onSelect = {
                        onEvent(NoteEvents.Order(NoteOrder.Date(noteState.noteOrder.orderType)))
                    }
                )
                Spacer(
                    modifier = Modifier.width(MaterialTheme.spacing.small)
                )
                DefaultRadioButton(
                    text = "Title",
                    selected = noteState.noteOrder is NoteOrder.Title,
                    onSelect = {
                        onEvent(NoteEvents.Order(NoteOrder.Title(noteState.noteOrder.orderType)))
                    }
                )
                Spacer(
                    modifier = Modifier.width(MaterialTheme.spacing.small)
                )
                DefaultRadioButton(
                    text = "Color",
                    selected = noteState.noteOrder is NoteOrder.Color,
                    onSelect = {
                        onEvent(NoteEvents.Order(NoteOrder.Color(noteState.noteOrder.orderType)))
                    }
                )
            }
        }
        Column (
            modifier= Modifier
                .size(60.dp,80.dp)
                .padding(
                    horizontal = MaterialTheme.spacing.small
                ),
            verticalArrangement = Arrangement.Center
        ){
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDownward,
                    contentDescription = null
                )
            }
        }
    }
}