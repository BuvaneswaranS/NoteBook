package com.example.task_2_notes.notesdatabase

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class NoteRespository(val notesDao: NotesDao) {

    val notes: LiveData<List<NotesData>> = notesDao.getAllNotes()

    suspend fun insert(notesData: NotesData){
            Log.i("TestingApp", "Inserted Came")
            notesDao.insertNotesData(notesData)
            Log.i("TestingApp", "Inserted Sucessfully")
    }

    suspend fun update(notesData: NotesData){
        notesDao.updateNotesData(notesData)
    }

//    suspend fun getAllNotes(): LiveData<List<NotesData>>{
//        return notesDao.getAllNotes()
//    }



    suspend fun getNote(): NotesData{
        return  notesDao.getNote()
    }

    suspend fun getNotesForSeparateTable(folder_name: String): LiveData<List<NotesData>>{
        return notesDao.getNotesForSeparateTable(folder_name)
    }

    suspend fun deleteNote(noteDataToBeDeleted: NotesData){
        notesDao.deleteNote(noteDataToBeDeleted)
    }

    suspend fun deleteAllNotesOfFolder(tableName: String){
        notesDao.deleteNotesOfFolder(tableName)
    }

}