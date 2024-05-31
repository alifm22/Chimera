package com.example.chimera.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.chimera.core.domain.Screen
import com.example.chimera.dashboard.presentation.Dashboard
import com.example.chimera.notes.presentation.screens.detail_screen.NoteDetail
import com.example.chimera.notes.presentation.screens.detail_screen.NoteDetailAssistedFactory
import com.example.chimera.notes.presentation.screens.detail_screen.NoteDetailViewModel
import com.example.chimera.notes.presentation.screens.detail_screen.NoteDetailedViewModelFactory
import com.example.chimera.notes.presentation.screens.note_screen.Notes
import com.example.chimera.notes.presentation.screens.note_screen.NotesViewModel

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    noteAssistedFactory: NoteDetailAssistedFactory
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.DashboardScreen.route
    ) {

// Dashboard Screen -----------------------------------------------------------------------
        composable(
            route = Screen.DashboardScreen.route
        ) {
            Dashboard(navController = navHostController)
        }
// Notes Screen ---------------------------------------------------------------------------
        composable(
            route = Screen.NotesScreen.route
        ) {
            val noteViewModel = hiltViewModel<NotesViewModel>()
            val noteState by noteViewModel.state.collectAsState()
            Notes(
                noteState = noteState,
                onEvent = noteViewModel::onEvent,
                modifier = Modifier,
                navController = navHostController,
            )
        }
// Notes Detail Screen -------------------------------------------------------------------
        composable(
            route = "${Screen.NoteDetailScreen.route}?id={id}?edit={edit}",
            arguments = listOf(
                navArgument("id") {
                    NavType.LongType
                    defaultValue = -1L
                },
                navArgument("edit"){
                    NavType.BoolType
                    defaultValue = true
                }
            )
        ){backStackEntry ->
            val noteId = backStackEntry.arguments?.getLong("id") ?: -1L
            val edit = backStackEntry.arguments?.getBoolean("edit")
            val noteDetailViewModel = viewModel(
                modelClass = NoteDetailViewModel::class.java,
                factory = NoteDetailedViewModelFactory(
                    noteId = noteId,
                    assistedFactory = noteAssistedFactory
                )
            )
            val noteDetailState = noteDetailViewModel.state

            NoteDetail(
                navController = navHostController,
                noteDetailState = noteDetailState,
                isEditMode = edit,
                isUpdatingNote = noteId != -1L,
                onEvent = noteDetailViewModel::onEvent
            )
        }

    }
}