package com.example.chimera.notes.presentation.screens.note_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.chimera.core.data.local.model.Menu
import com.example.chimera.core.data.local.model.MenuCategory
import com.example.chimera.core.presentation.BottomMenu
import com.example.chimera.notes.presentation.events.NoteEvents

@Composable
fun Notes(
    modifier: Modifier = Modifier,
    navController: NavController,
    noteState: NotesState,
    onEvent: (NoteEvents) -> Unit,
) {
    BottomMenu(
        navController = navController,
        menuItems = Menu.getItems(
            category = MenuCategory.Notes.name
        ),
    ) {
        NotesScreen(
            modifier = modifier,
            navController = navController,
            noteState = noteState,
            onEvent = onEvent
        )
    }
}
