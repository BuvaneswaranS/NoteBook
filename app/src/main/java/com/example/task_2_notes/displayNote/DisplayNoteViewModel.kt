package com.example.task_2_notes.displayNote

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.task_2_notes.notesdatabase.NoteRespository
import com.example.task_2_notes.notesdatabase.NotesDao
import com.example.task_2_notes.notesdatabase.NotesData
import com.example.task_2_notes.notesdatabase.NotesDatabase
import kotlinx.coroutines.*



class DisplayNoteViewModel(application: Application): AndroidViewModel(application) {

    var respository: NoteRespository

    var noteTitle: String = "Default Title"

    var noteDescription: String = "Default Descriptipm"

     private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.IO + viewModelJob)


    init {
        val databaseDao by lazy { NotesDatabase.getDatabaseInstance(application.applicationContext).notesDao}
        respository = NoteRespository(databaseDao)
    }

     fun addNote(notesData: NotesData){
         Log.i("TestingApp","Title = ${noteTitle}")
         Log.i("TestingApp","Description = ${noteDescription}")

         uiScope.launch {
            Log.i("TestingApp","Entered addNoteFunction")
             respository.insert(notesData)

        }
    }

    override fun onCleared() {
        viewModelJob.cancel()
        super.onCleared()

    }

}