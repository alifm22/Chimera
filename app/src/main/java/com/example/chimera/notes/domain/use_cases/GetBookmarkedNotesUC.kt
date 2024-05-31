package com.example.chimera.notes.domain.use_cases

import com.example.chimera.notes.data.local.model.Note
import com.example.chimera.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarkedNotesUC @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke():Flow<List<Note>> {
        return repository.getBookmarkedNotes()
    }
}