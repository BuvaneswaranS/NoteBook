package com.example.task_2_notes.displayfolder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task_2_notes.notesdatabase.NoteRespository
import java.lang.IllegalArgumentException

class DisplayFolderViewModelFactory(private val respository: NoteRespository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DisplayFolderViewModal::class.java)){
            @Suppress("UNCHECKED_CAST")
            return DisplayFolderViewModal(respository) as T
        }
        throw IllegalArgumentException("Unknown BiewModel Class")
    }
}