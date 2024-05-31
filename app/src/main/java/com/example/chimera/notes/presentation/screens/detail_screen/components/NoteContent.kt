package com.example.chimera.notes.presentation.screens.detail_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chimera.notes.presentation.events.NoteDetailEvents
import com.example.chimera.ui.theme.spacing

@Composable
fun NoteContent(
    content: String,
    color: Int,
    isTitle: Boolean,
    edit: Boolean? = true,
    onEvent: (NoteDetailEvents) -> Unit,
//    onContentChange: (String) -> Unit,
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(
                vertical = MaterialTheme.spacing.xSmall,
                horizontal = MaterialTheme.spacing.medium
            )
    ){
        NoteTextField(
            modifier = Modifier.fillMaxSize(),
            value = content,
            onEvent = onEvent,
//            onValueChange = onContentChange,
            label = "Content",
            color = color,
            isEditable = edit,
            isTitle = isTitle,
        )
    }

}