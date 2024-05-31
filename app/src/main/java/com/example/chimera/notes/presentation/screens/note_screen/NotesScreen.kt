package com.example.chimera.notes.presentation.screens.note_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.chimera.notes.presentation.events.NoteEvents
import com.example.chimera.notes.presentation.screens.note_screen.components.NotePaper
import com.example.chimera.notes.presentation.screens.note_screen.components.NoteTopBar
import com.example.chimera.ui.theme.spacing
import com.example.chimera.ui.theme.values

@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    noteState: NotesState,
    onEvent: (NoteEvents) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = MaterialTheme.values.peekHeight)
    ) {
        NoteTopBar(
            noteState = noteState,
            onEvent = onEvent
        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(
                MaterialTheme.values.notesGridColumnCount
            ),
            contentPadding = PaddingValues(
                MaterialTheme.spacing.xSmall
            ),
        ) {
            items(noteState.notes) { note ->
                NotePaper(
                    navController = navController,
                    note = note,
                    onEvent = onEvent
                )
            }
        }
    }

}