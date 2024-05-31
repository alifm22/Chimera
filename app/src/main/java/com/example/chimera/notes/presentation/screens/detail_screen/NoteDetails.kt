package com.example.chimera.notes.presentation.screens.detail_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.chimera.core.data.local.model.Menu
import com.example.chimera.core.data.local.model.MenuCategory
import com.example.chimera.core.presentation.BottomMenu
import com.example.chimera.core.presentation.components.rememberImeState
import com.example.chimera.notes.presentation.events.NoteDetailEvents

@Composable
fun NoteDetail(
    navController: NavController,
    modifier: Modifier = Modifier,
    noteDetailState: NoteDetailState,
    onEvent: (NoteDetailEvents) -> Unit,
    isEditMode: Boolean? = true,
    isUpdatingNote: Boolean
) {

    val imeState = rememberImeState()

    BottomMenu(
        navController = navController,
        isVisible = !imeState.value,
        menuItems = Menu.getItems(
            category = MenuCategory.NoteDetail.name
        )
    ) {
        NoteDetailScreen(
            navController = navController,
            modifier = modifier,
            noteDetailState = noteDetailState,
            onEvent = onEvent,
            isEditMode = isEditMode,
            isUpdatingNote = isUpdatingNote
//            isUpdatingNote = state.isUpdatingNote,
//            title = state.title,
//            content = state.content,
//            isBookmarked = state.isBookmarked,
//            color = state.color,
//            edit = edit,
//            onBookmarkChange = viewModel::onBookmarkChange,
//            onTitleChange = viewModel::onTitleChange,
//            onContentChange = viewModel::onContentChange,
//            onColorChange = viewModel::onColorChange,
//            onButtonClick = {
//                viewModel.addOrUpdateNote()
//                navigateUp()
//            },
        )
    }
}