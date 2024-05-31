package com.example.chimera.notes.domain.repository

import com.example.chimera.notes.data.local.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes():Flow<List<Note>>
    fun getNoteById(id:Long): Flow<Note>
    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(id: Long)
    fun getBookmarkedNotes(): Flow<List<Note>>
}