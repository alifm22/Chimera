package com.example.chimera.notes.presentation.events

import com.example.chimera.notes.data.local.model.Note
import com.example.chimera.notes.domain.util.NoteOrder

sealed class NoteEvents {
    data class Order(val noteOrder: NoteOrder): NoteEvents()
    data class DeleteNote(val note: Note): NoteEvents()
    data class ToggleBookmark(val note: Note): NoteEvents()
    object RestoreNote: NoteEvents()
    object ToggleFilter: NoteEvents()
}