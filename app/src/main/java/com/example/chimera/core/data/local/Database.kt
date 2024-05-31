package com.example.chimera.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.chimera.notes.data.local.NoteDao
import com.example.chimera.notes.data.local.converters.DateConverter
import com.example.chimera.notes.data.local.model.Note


@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class Database: RoomDatabase() {
    abstract val noteDao:NoteDao
}