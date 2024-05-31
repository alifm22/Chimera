package com.example.chimera.notes.presentation.screens.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chimera.R
import com.example.chimera.core.domain.Screen
import com.example.chimera.notes.presentation.events.NoteDetailEvents
import com.example.chimera.notes.presentation.screens.detail_screen.NoteDetailState
import com.example.chimera.ui.theme.spacing
import com.example.chimera.ui.theme.values

@Composable
fun DetailsTopBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    noteDetailState: NoteDetailState,
    isButtonDisabled: Boolean = true,
    isUpdatingNote: Boolean = false,
    onEvent: (NoteDetailEvents) -> Unit,
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
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.xSmall)
                .size(MaterialTheme.values.smallIconSize),
            imageVector = Icons.Default.PostAdd,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = noteDetailState.title,
            modifier = modifier
                .background(MaterialTheme.colorScheme.outlineVariant),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {
                onEvent(NoteDetailEvents.AddUpdateNote)
                navController.navigate(Screen.NotesScreen.route)
            },
            enabled = !isButtonDisabled
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = if (isUpdatingNote) Icons.Default.Update
                else Icons.Default.AddTask,
                contentDescription = null,
                tint = if (isButtonDisabled && isSystemInDarkTheme())
                    colorResource(id = R.color.onLightGrey)
                else if (isButtonDisabled && !isSystemInDarkTheme())
                    colorResource(id = R.color.lightGrey)
                else colorResource(id = R.color.green)
            )
        }
    }
}