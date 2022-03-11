package com.example.task_2_notes.homefragment

import android.util.Log
import androidx.lifecycle.ViewModel

class homeViewModal: ViewModel() {

    val word: String = "Jeff Bezos"

    init {
        Log.i("HomeViewModal","Home ViewModal is created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("HomeViewModal","Home ViewModal is destroyed")
    }

}