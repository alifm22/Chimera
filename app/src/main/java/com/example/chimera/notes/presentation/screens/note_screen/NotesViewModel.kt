package com.example.chimera.notes.presentation.screens.note_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chimera.notes.data.local.model.Note
import com.example.chimera.notes.domain.use_cases.NoteUCs
import com.example.chimera.notes.domain.util.NoteOrder
import com.example.chimera.notes.domain.util.OrderType
import com.example.chimera.notes.presentation.events.NoteEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUCs: NoteUCs,
) : ViewModel() {

    private val _state: MutableStateFlow<NotesState> = MutableStateFlow(NotesState())
    val state: StateFlow<NotesState> = _state.asStateFlow()

    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        getAllNotes(NoteOrder.Color(OrderType.Descending))
    }

    fun onEvent(event: NoteEvents) {
        when (event) {
            is NoteEvents.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getAllNotes(event.noteOrder)
            }

            is NoteEvents.DeleteNote -> {
                viewModelScope.launch {
                    noteUCs.deleteNoteUC(event.note.id)
                    recentlyDeletedNote = event.note
                }
            }

            is NoteEvents.ToggleBookmark -> {
                viewModelScope.launch {
                    noteUCs.addNoteUC(
                        event.note.copy(
                            isBookmarked = !event.note.isBookmarked
                        )
                    )
                }
            }

            is NoteEvents.RestoreNote -> {
                viewModelScope.launch {
                    noteUCs.addNoteUC(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            is NoteEvents.ToggleFilter -> {
                _state.value = state.value.copy(
                    isFilterVisible = !state.value.isFilterVisible
                )
            }

        }
    }

    private fun getAllNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUCs.getAllNotesUC(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .catch {
                _state.value = NotesState()
            }
            .launchIn(viewModelScope)
    }
}

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder =
        NoteOrder.Date(OrderType.Descending),
    val isFilterVisible: Boolean = false,
)