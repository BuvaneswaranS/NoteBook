package com.example.task_2_notes.displaycard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.task_2_notes.R
import com.example.task_2_notes.databinding.FragmentDisplayCardBinding
import com.example.task_2_notes.notesdatabase.NotesDatabase


class DisplayCardFragment : Fragment() {

    private lateinit var binding: FragmentDisplayCardBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_display_card, container, false)

//        val application = requireNotNull(this.activity).application
//
//        val dataSource = NotesDatabase.getDatabaseInstance(application).notesDao
//
//        val viewModelFactory = displayNoteViewModalFactory(dataSource,application)
//
//        val viewmodel = ViewModelProvider(this, viewModelFactory).get(displayNoteViewModel::class.java)
//

        binding.saveBtn.setOnClickListener {
            Log.i("Testing","Data SAved")
        }

        return binding.root
    }

}