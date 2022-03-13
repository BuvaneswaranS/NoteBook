package com.example.task_2_notes.notesdatabase

import android.util.Log


class NoteRespository(val notesDao: NotesDao) {

    suspend fun insert(notesData: NotesData){
        Log.i("TestingApp", "Inserted Came")
        notesDao.insertNotesData(notesData)
        Log.i("TestingApp", "Inserted Sucessfully")
    }

    suspend fun update(notesData: NotesData){
        notesDao.updateNotesData(notesData)
    }

    suspend fun getAllNotes(): List<NotesData>{
        return notesDao.getAllNotes()
    }

    suspend fun getNote(): NotesData{
        return  notesDao.getNote()
    }

    suspend fun getNotesForSeparateTable(folder_name: String): List<NotesData>{
        return notesDao.getNotesForSeparateTable(folder_name)
    }

    suspend fun deleteNote(key : Long){
        notesDao.deleteNote(key)
    }

    suspend fun deleteAllNotesOfFolder(tableName: String){
        notesDao.deleteNotesOfFolder(tableName)
    }

}