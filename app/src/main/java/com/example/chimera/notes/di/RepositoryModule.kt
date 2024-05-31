package com.example.chimera.notes.di

import com.example.chimera.notes.data.repository.NoteRepositoryImpl
import com.example.chimera.notes.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(repositoryImpl: NoteRepositoryImpl):NoteRepository
}