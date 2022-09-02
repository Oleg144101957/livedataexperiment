package com.example.livedataexperiment.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.livedataexperiment.models.Note


@Dao
interface NoteDao {

    @Query("SELECT * FROM NOTE_TABLE")
    fun readAllNotes(): LiveData<List<Note>>

    @Insert
    fun addNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

}