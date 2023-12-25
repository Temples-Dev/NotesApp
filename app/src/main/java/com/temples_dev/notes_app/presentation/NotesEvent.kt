package com.temples_dev.notes_app.presentation

import com.temples_dev.notes_app.data.Note

sealed interface NotesEvent {

    data object SortNotes : NotesEvent

    data class DeleteNote(val note: Note) : NotesEvent

    data class SaveNote(
        val title: String,
        val description: String
    ) : NotesEvent

}