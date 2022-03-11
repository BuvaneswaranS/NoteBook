package com.example.task_2_notes.homefragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class HomeViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(homeViewModal::class.java)){
            return homeViewModal() as T
        }
        throw IllegalArgumentException("Unknown ViewModal Class")
    }
}