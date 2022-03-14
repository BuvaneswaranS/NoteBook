package com.example.task_2_notes.updateNote

import androidx.lifecycle.ViewModel
import com.example.task_2_notes.notesdatabase.NoteRespository
import com.example.task_2_notes.notesdatabase.NotesData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UpdateNoteViewModel (val respository: NoteRespository): ViewModel() {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.IO + viewModelJob)


    fun update(updatedNoteData: NotesData){
        uiScope.launch {
            respository.update(updatedNoteData)
        }
    }

    override fun onCleared() {
        viewModelJob.cancel()
        super.onCleared()
    }

}