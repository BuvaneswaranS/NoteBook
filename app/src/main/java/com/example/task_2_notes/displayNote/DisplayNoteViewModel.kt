package com.example.task_2_notes.displayNote

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.task_2_notes.notesdatabase.NotesDao
import com.example.task_2_notes.notesdatabase.NotesData
import com.example.task_2_notes.notesdatabase.NotesDatabase
import kotlinx.coroutines.*



class DisplayNoteViewModel(application: Application): AndroidViewModel(application) {

    val database = NotesDatabase.getDatabaseInstance(application).notesDao

    var data: NotesData = NotesData()

    var noteTitle: String = "Default Title"

    var noteDescription: String = "Default Descriptipm"

     private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    init {

    }

     fun addNote(){
         Log.i("TestingApp","Title = ${noteTitle}")
         Log.i("TestingApp","Description = ${noteDescription}")
         data.title = noteTitle
         data.description = noteDescription

         uiScope.launch {
            Log.i("TestingApp","Entered addNoteFunction")
            insertNote(data)
        }
    }

    private suspend fun insertNote(note: NotesData){
        withContext(Dispatchers.IO){
            database.insertNotesData(note)
            Log.i("TestingApp","Entered suspend function")
        }
    }

    override fun onCleared() {
        viewModelJob.cancel()
        super.onCleared()

    }

}