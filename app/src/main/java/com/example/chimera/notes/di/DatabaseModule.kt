package com.example.chimera.notes.di

import android.content.Context
import androidx.room.Room
import com.example.chimera.core.data.local.Database
import com.example.chimera.notes.data.local.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNoteDao(database: Database):NoteDao =
        database.noteDao


    @Provides
    @Singleton
    fun provideNoteDatabase(
        @ApplicationContext context:Context
    ):Database = Room.databaseBuilder(
        context,
        Database::class.java,
        "chimera_db"
    ).build()
}