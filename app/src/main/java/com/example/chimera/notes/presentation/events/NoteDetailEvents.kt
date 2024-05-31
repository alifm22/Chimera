package com.example.chimera.notes.presentation.events

sealed class NoteDetailEvents {
    data class TitleChange(val title: String): NoteDetailEvents()
    data class ContentChange(val content: String): NoteDetailEvents()
    data class ColorChange(val color: Int): NoteDetailEvents()
    object ToggleBookmark: NoteDetailEvents()
    object AddUpdateNote: NoteDetailEvents()
}