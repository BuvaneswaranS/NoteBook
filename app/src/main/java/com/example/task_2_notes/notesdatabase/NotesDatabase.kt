package com.example.task_2_notes.notesdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NotesData::class, FolderData::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {

    abstract val notesDao: NotesDao

    companion object{

        @Volatile
        private var DATABASE_INSTANCE: NotesDatabase? = null

        fun getDatabaseInstance(context: Context): NotesDatabase{

            synchronized(this){
                var instance = DATABASE_INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,NotesDatabase::class.java,"notes_database").fallbackToDestructiveMigration().build()
                    DATABASE_INSTANCE = instance
                }
                return instance
            }
        }
    }
}