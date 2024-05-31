package com.example.chimera.notes.presentation.screens.note_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.graphics.ColorUtils
import androidx.navigation.NavController
import com.example.chimera.core.domain.Screen
import com.example.chimera.notes.data.local.model.Note
import com.example.chimera.notes.presentation.components.getOnColor
import com.example.chimera.notes.presentation.events.NoteEvents
import com.example.chimera.ui.theme.spacing
import com.example.chimera.ui.theme.values

@Composable
fun NotePaper(
    modifier: Modifier = Modifier,
    navController: NavController,
    note: Note,
    onEvent: (NoteEvents) -> Unit,
) {
    val cutCornerSize = MaterialTheme.values.cutCornerSize
    val cornerRadius = MaterialTheme.values.cornerRadius
    Box(
        modifier = modifier
            .padding(MaterialTheme.spacing.xSmall)
            .clickable {
                navController.
                navigate("${Screen.NoteDetailScreen.route}?id=${note.id}?edit=${false}")
            }
    ) {
        val noteColor = colorResource(id = note.color)
        Canvas(
            modifier = Modifier.matchParentSize()
        ) {
            val path = Path().apply {
                lineTo(
                    size.width - cutCornerSize.toPx(), 0f)
                lineTo(size.width, cutCornerSize.toPx())
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
            clipPath(path) {
                drawRoundRect(
                    color = noteColor,
                    size = size,
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
                drawRoundRect(
                    color = Color(
                        ColorUtils.blendARGB(note.color, 0x000000, 0.2f)
                    ),
                    topLeft = Offset(size.width - cutCornerSize.toPx(), -100f),
                    size = Size(cutCornerSize.toPx() + 100f, cutCornerSize.toPx() + 100f),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = MaterialTheme.spacing.large,
                    start = MaterialTheme.spacing.medium,
                    end = MaterialTheme.spacing.medium,
                    bottom = MaterialTheme.spacing.default
                ),
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.titleLarge,
                color = colorResource(id = getOnColor(note.color)),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.spacing.xSmall)
            )
            Text(
                text = note.content,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = getOnColor(note.color)),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.spacing.small)
            )
            NotePaperActionBar(
                note = note,
                navController = navController,
                onEvent = onEvent
            )
        }
    }
}


