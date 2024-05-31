package com.example.chimera.notes.domain.use_cases

import javax.inject.Inject

data class NoteUCs @Inject constructor(
    val getAllNotesUC: GetAllNotesUC,
    val deleteNoteUC: DeleteNoteUC,
    val addNoteUC: AddNoteUC,
    val getNoteByIdUC: GetNoteByIdUC,
    val getBookmarkedNotesUC: GetBookmarkedNotesUC
)
