package com.example.chimera.notes.presentation.screens.detail_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.chimera.R
import com.example.chimera.notes.data.local.model.Note
import com.example.chimera.notes.domain.use_cases.AddNoteUC
import com.example.chimera.notes.domain.use_cases.GetNoteByIdUC
import com.example.chimera.notes.presentation.events.NoteDetailEvents
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Date

class NoteDetailViewModel @AssistedInject constructor(
    private val addNoteUC: AddNoteUC,
    private val getNoteByIdUC: GetNoteByIdUC,
    @Assisted private val noteId: Long,
) : ViewModel() {
    var state by mutableStateOf(NoteDetailState())
        private set
    val isFormNotBlank: Boolean
        get() = state.title.isNotEmpty() && state.content.isNotEmpty()
    private val note: Note
        get() = state.run {
            Note(
                id = id,
                title = title,
                content = content,
                createdDate = createdDate,
                isBookmarked = isBookmarked,
                color = color
            )
        }

    init {
        initialize()
    }

    private fun initialize() {
        val isUpdatingNote = noteId != -1L
        state = state.copy(isUpdatingNote = isUpdatingNote)
        if (isUpdatingNote) {
            getNoteById()
        }
    }

    private fun getNoteById() = viewModelScope.launch {
        getNoteByIdUC(noteId).collectLatest { note ->
            state = state.copy(
                id = note.id,
                title = note.title,
                content = note.content,
                isBookmarked = note.isBookmarked,
                createdDate = note.createdDate,
                color = note.color
            )
        }
    }

    fun onEvent (event: NoteDetailEvents){
        when (event){
            is NoteDetailEvents.TitleChange -> {
                state = state.copy(title = event.title)
            }
            is NoteDetailEvents.ContentChange -> {
                state = state.copy(content = event.content)
            }
            is NoteDetailEvents.ToggleBookmark -> {
                state = state.copy(isBookmarked = !state.isBookmarked)
            }
            is NoteDetailEvents.ColorChange -> {
                state = state.copy(color = event.color)
            }
            is NoteDetailEvents.AddUpdateNote -> {
                viewModelScope.launch {
                    addNoteUC(note = note)
                }
            }
        }
    }
}

data class NoteDetailState(
    val id: Long = 0,
    val title: String = "",
    val content: String = "",
    val isBookmarked: Boolean = false,
    val createdDate: Date = Date(),
    val isUpdatingNote: Boolean = false,
    val color: Int = R.color.noteYellow,
)

class NoteDetailedViewModelFactory(
    private val noteId: Long,
    private val assistedFactory: NoteDetailAssistedFactory,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return assistedFactory.create(noteId) as T
    }
}

@AssistedFactory
interface NoteDetailAssistedFactory {
    fun create(noteId: Long): NoteDetailViewModel
}