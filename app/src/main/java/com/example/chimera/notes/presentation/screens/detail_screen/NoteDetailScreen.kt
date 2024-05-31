package com.example.chimera.notes.presentation.screens.detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chimera.notes.presentation.components.getOnColor
import com.example.chimera.notes.presentation.events.NoteDetailEvents
import com.example.chimera.notes.presentation.screens.detail_screen.components.DetailsTopBar
import com.example.chimera.notes.presentation.screens.detail_screen.components.NoteColor
import com.example.chimera.notes.presentation.screens.detail_screen.components.NoteContent
import com.example.chimera.notes.presentation.screens.detail_screen.components.NoteTitle
import com.example.chimera.ui.theme.spacing

@Composable
fun NoteDetailScreen(
    navController: NavController,
    modifier: Modifier,
    noteDetailState: NoteDetailState,
    onEvent: (NoteDetailEvents) -> Unit,
    isEditMode: Boolean? = true,
    isUpdatingNote: Boolean
//    isUpdatingNote: Boolean,
//    title: String,
//    content: String,
//    isBookmarked: Boolean,
//    color: Int,
//    edit: Boolean? = true,
//    onBookmarkChange: (Boolean) -> Unit,
//    onTitleChange: (String) -> Unit,
//    onContentChange: (String) -> Unit,
//    onColorChange: (Int) -> Unit,
//    onButtonClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(id = noteDetailState.color))
    ) {
        DetailsTopBar(
            navController = navController,
            noteDetailState = noteDetailState,
            isButtonDisabled = noteDetailState.title.isEmpty() || noteDetailState.content.isEmpty(),
            isUpdatingNote = isUpdatingNote,
            onEvent = onEvent
        )
        if (isEditMode == true){
            Spacer(modifier = Modifier
                .size(MaterialTheme.spacing.medium))
            NoteColor(
                color = noteDetailState.color,
                onEvent = onEvent
            )
        }
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.small))
        NoteTitle(
            noteDetailState = noteDetailState,
            onEvent = onEvent,
            text = noteDetailState.title,
            isTitle = true,
            isEditMode = isEditMode,
            isBookmarked = noteDetailState.isBookmarked,
            color = noteDetailState.color
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Transparent,
                            colorResource(id = getOnColor(color = noteDetailState.color)),
                            Color.Transparent
                        )
                    )
                )
        )
        Spacer(modifier = Modifier
            .size(MaterialTheme.spacing.xSmall))
        NoteContent(
            content = noteDetailState.content,
            color = noteDetailState.color,
            edit = isEditMode,
//            onContentChange = onContentChange,
            isTitle = false,
            onEvent = onEvent
        )
    }
}
