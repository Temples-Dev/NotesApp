package com.temples_dev.notes_app.di

import android.app.Application
import androidx.room.Room
import com.temples_dev.notes_app.data.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext application: Application):NotesDatabase {

        return Room.databaseBuilder(
            application,
            NotesDatabase::class.java,
            "notes.db"
        ).build()

    }
}