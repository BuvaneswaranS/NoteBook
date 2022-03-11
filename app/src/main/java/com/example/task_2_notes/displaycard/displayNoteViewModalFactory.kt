package com.example.task_2_notes.displaycard

//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.task_2_notes.notesdatabase.NotesDao
//
//class displayNoteViewModalFactory(private val database: NotesDao, private val application: Application): ViewModelProvider.Factory {
//    @Suppress()
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(displayNoteViewModel::class.java)){
//            return displayNoteViewModel(database,application) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModal class")
//    }
//
//
//}