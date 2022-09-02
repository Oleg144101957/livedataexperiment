package com.example.livedataexperiment.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.livedataexperiment.DB_NAME
import com.example.livedataexperiment.models.Note


@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class NoteDB : RoomDatabase(){

    abstract fun getNoteDao() : NoteDao

    companion object {

        @Volatile
        var INSTANCE: NoteDB? = null

        fun getNoteDatabase(context: Context) : NoteDB {
            val tmp = INSTANCE
            if (tmp != null) return tmp

            synchronized(this){

                val instance = Room.databaseBuilder(context, NoteDB::class.java, DB_NAME).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}