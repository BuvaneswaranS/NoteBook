package com.example.task_2_notes.displayNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task_2_notes.notesdatabase.NoteRespository
import java.lang.IllegalArgumentException

class DisplayNoteViewModelFactory(private val respository: NoteRespository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DisplayNoteViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return DisplayNoteViewModel(respository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}