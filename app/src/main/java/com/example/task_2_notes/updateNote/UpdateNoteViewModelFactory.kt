package com.example.task_2_notes.updateNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task_2_notes.notesdatabase.NoteRespository
import java.lang.IllegalArgumentException

class UpdateNoteViewModelFactory(private val respository: NoteRespository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UpdateNoteViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return UpdateNoteViewModel(respository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
