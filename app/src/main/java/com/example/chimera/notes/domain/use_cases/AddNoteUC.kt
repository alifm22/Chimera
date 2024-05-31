package com.example.chimera.notes.domain.use_cases

import com.example.chimera.notes.data.local.model.Note
import com.example.chimera.notes.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUC @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) =
        repository.insertNote(note)
}