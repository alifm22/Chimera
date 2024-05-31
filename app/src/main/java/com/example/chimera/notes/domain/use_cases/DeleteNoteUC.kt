package com.example.chimera.notes.domain.use_cases

import com.example.chimera.notes.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUC @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id:Long) =
        repository.deleteNote(id)
}