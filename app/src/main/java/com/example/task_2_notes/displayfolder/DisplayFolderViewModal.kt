package com.example.task_2_notes.displayfolder


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.task_2_notes.notesdatabase.NoteRespository
import com.example.task_2_notes.notesdatabase.NotesData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DisplayFolderViewModal(val respository: NoteRespository): ViewModel() {

    private val viewModelJob = Job()

    private val scope = CoroutineScope(Dispatchers.IO + viewModelJob)

//    var entireNotesList: LiveData<List<NotesData>>

      lateinit var notesList: LiveData<List<NotesData>>


    fun getDataBasedOnFolderName(folder_name: String){
        scope.launch {
            notesList = respository.getNotesForSeparateTable(folder_name)
        }
    }

    fun deleteNote(note: NotesData){
        scope.launch {
            respository.deleteNote(note)
        }
    }


}